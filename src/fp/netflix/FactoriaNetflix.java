package fp.netflix;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fp.utiles.Checkers;
import fp.netflix.ProduccionNetflix;


public class FactoriaNetflix {

	public static ProduccionNetflix parse(String s) {
		String[] a = s.split(",");
		Checkers.check("Formato no válido", a.length == 8);
		String titulo = a[0].trim();
		Tipo tipo = Tipo.valueOf(a[1].trim());
		Integer año = Integer.parseInt(a[2].trim());
		Duration duracion = Duration.of(Long.parseLong(a[3].trim()), ChronoUnit.MINUTES);
		Set<String> generos = parseaGeneros(a[4].trim());
		Integer temporadas = Integer.parseInt(a[5].trim());
		Double score = Double.parseDouble(a[6].trim());
		Long popularidad = Long.parseLong(a[7].trim());
		
		return new ProduccionNetflix(titulo, tipo, año, duracion, generos, temporadas, new EstadisticasIMDB(score, popularidad));
	}

	private static Set<String> parseaGeneros(String generos) {
		Set<String> res = new HashSet<>();
		String generosLimpio = generos.replace("[", "").replace("]", "").replace("'", "").trim();
		String[] partes = generosLimpio.split(";");
		
		// OPCION 1:
		// return Array.stream(partes).collect(Collectors.toSet());
		
		// OPCION 2:
		for (String parte : partes) {
			res.add(parte.trim());
		}
		return res;
	}
	
}
