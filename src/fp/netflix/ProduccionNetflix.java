package fp.netflix;

import java.time.Duration;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public class ProduccionNetflix implements Comparable<ProduccionNetflix>{

	private String titulo;
	private Tipo tipo;
	private Integer año;
	private Duration duracion;
	private Set<String> generos;
	private Integer numeroTemporadas;
	private EstadisticasIMDB estadisticas;
	
	public ProduccionNetflix(String titulo, Tipo tipo, Integer año, Duration duracion, Set<String> generos, Integer temporadas, EstadisticasIMDB estadisticas) {
		
		Checkers.check("año incorrecto", año >= 1900);
		Checkers.check("número de temporadas incorrecto", (tipo.equals(tipo.MOVIE) && temporadas == 0) || tipo.equals(tipo.SHOW) && temporadas >= 1 );
		
		this.titulo = titulo;
		this.tipo = tipo;
		this.año = año;
		this.duracion = duracion;
		this.generos = new HashSet<String>();
		this.generos.addAll(generos);
		this.numeroTemporadas = temporadas;
		this.estadisticas = estadisticas;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Integer getAño() {
		return año;
	}

	public Set<String> getGeneros() {
		return new HashSet<String>(generos);
	}

	public Integer getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public EstadisticasIMDB getEstadisticas() {
		return estadisticas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(año, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProduccionNetflix other = (ProduccionNetflix) obj;
		return Objects.equals(año, other.año) && Objects.equals(titulo, other.titulo);
	}
	
	
	@Override
	public int compareTo(ProduccionNetflix o) {
		Integer res = titulo.compareTo(o.getTitulo());
		if (res == 0) {
			res = año.compareTo(o.getAño());
		}
		return res;
	}

	@Override
	public String toString() {
		return "ProduccionNetflix [titulo=" + titulo + ", tipo=" + tipo + ", año=" + año + ", generos=" + generos
				+ ", numeroTemporadas=" + numeroTemporadas + ", estadisticas=" + estadisticas + "]";
	}

}
