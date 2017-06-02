package br.ufes.sdman.dashboard.domain;

import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;

public class Usuario_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, String> telefone;
	public static volatile SingularAttribute<Usuario, String> cpf;
	public static volatile SingularAttribute<Usuario, Date> dataNascimento;	
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SetAttribute<Usuario, Projeto> schoolRooms;
	
}
