package entidades.banco;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pais.class)
public abstract class Pais_ {

	public static volatile SingularAttribute<Pais, String> sigla;
	public static volatile CollectionAttribute<Pais, Estado> estadoCollection;
	public static volatile SingularAttribute<Pais, String> nome;
	public static volatile SingularAttribute<Pais, Integer> id;

}

