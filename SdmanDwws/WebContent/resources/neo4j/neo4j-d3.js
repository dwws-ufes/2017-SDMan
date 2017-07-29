    var r= require("request");
    var txUrl = "http://localhost:7474/db/data/transaction/commit";
    r.setRequestHeader('Authorization', 'Basic ' + 'Basic bmVvNGo6c2RtYW4=');
    function cypher(query,params,cb) {
    	  r.post({uri:txUrl,
    	          json:JSON.stringify({ "statements": [{ "statement": "MATCH path = (n)-[r]->(m) RETURN path", "resultDataContents": ["graph"] }] }),
    	          function(err,res) { cb(err,res.body)}
    	          })
    	}
   
    var data = cypher(query,params,cb);

    function idIndex(a, id) {
        for (var i = 0; i < a.length; i++) {
            if (a[i].id == id) return i;
        }
        return null;
    }
    
    var nodes = [],
        links = [];
    
    data.forEach(function(row) {
        row.graph.nodes.forEach(function(n) {
            if (idIndex(nodes, n.id) == null)
                nodes.push({ id: n.id, label: n.labels[0], title: n.properties });
        });
        links = links.concat(row.graph.relationships.map(function(r) {
            return { source: idIndex(nodes, r.startNode), target: idIndex(nodes, r.endNode), type: r.type };
        }));
    });
    graphNeo = { nodes: nodes, links: links };
    
    var svgContainer = d3.select("#graph").append("svg")
        .attr("width", "100%").attr("height", "100%")
        .attr("pointer-events", "all");

    // use the force
    var force = d3.layout.force() //build the layout
        .size([800, 800]) //specified earlier
        .nodes(graphNeo.nodes) //add nodes
        .links(graphNeo.links) //add links
        .on("tick", tick) //what to do
        .linkDistance(150) //set for proper svg size
        .start(); //kick the party 

    // render relationships as lines
    var link = svgContainer.selectAll(".link")
        .data(graphNeo.links).enter()
        .append("line").attr("class", "link").style("stroke", "black");

    // render nodes as circles, css-class from label
    var node = svgContainer.selectAll(".node")
        .data(graphNeo.nodes).enter()
        .append("circle")
        .attr("class", function(d) { return "node " + d.label })
        .attr("r", 25)
        .style("fill", function(d) {
            if (d.label == "ComputeNode") {
                return "black";
            } else if (d.label == "Instance") {
                return "green";
            } else {
                return "blue";
            }
        })
        .call(force.drag);

    // html title attribute for title node-attribute
    node.append("title")
        .text(function(d) { return d.title.Name; })
        .style("fill", "white")
        .style('stroke', "white");

    function tick(e) {
        node.attr('cx', function(d) { return d.x; })
            .attr('cy', function(d) { return d.y; });


        link.attr('x1', function(d) { return d.source.x; })
            .attr('y1', function(d) { return d.source.y; })
            .attr('x2', function(d) { return d.target.x; })
            .attr('y2', function(d) { return d.target.y; });
    }