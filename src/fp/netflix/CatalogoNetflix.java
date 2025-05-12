package fp.netflix;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public class CatalogoNetflix {

	private SortedSet<ProduccionNetflix> producciones;
	
	public CatalogoNetflix(Stream<ProduccionNetflix> producciones) {
		this.producciones = new TreeSet<ProduccionNetflix>(Comparator.comparing(ProduccionNetflix::getAño).thenComparing(ProduccionNetflix::getTitulo));
		producciones.forEach(this.producciones::add);
	}

	@Override
	public int hashCode() {
		return Objects.hash(producciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CatalogoNetflix))
			return false;
		CatalogoNetflix other = (CatalogoNetflix) obj;
		return Objects.equals(producciones, other.producciones);
	}

	@Override
	public String toString() {
		return "CatalogoNetflix [producciones=" + producciones + "]";
	}
	
}
