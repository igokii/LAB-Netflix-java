package fp.netflix;

import fp.utiles.Checkers;

public record EstadisticasIMDB(Double score, Long popularidad) {
	
	public EstadisticasIMDB{
	Checkers.check("score de IMDB incorrecto", 0. <= score && score <=10.);
	Checkers.check("popularidad en IMDB incorrecta", popularidad > 0);
	}
	
}
