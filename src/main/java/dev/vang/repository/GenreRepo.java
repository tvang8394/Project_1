package dev.vang.repository;

import java.util.List;

import dev.vang.models.Genre;

public interface GenreRepo {
	public Genre getGenreById(Integer id);
	public List<Genre> getAllGenre();
}
