package br.ufes.sdman.dashboard.domain;

import javax.persistence.metamodel.SingularAttribute;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;

public class Projeto_ extends PersistentObjectSupport_{
	
	public static volatile SingularAttribute<Projeto, String> nome;
	public static volatile SingularAttribute<Projeto, Usuario> usuario;
	
}
