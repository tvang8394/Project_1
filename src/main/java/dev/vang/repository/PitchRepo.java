package dev.vang.repository;

import java.util.List;

import dev.vang.models.Pitch;

public interface PitchRepo {
	public Pitch getPitchById(Integer id);
	public List<Pitch> getAllPitch();
	public List<Pitch> getAllPitchByUser(Integer user_id);
	public void createPitch(Pitch p);
	public void updatePitch(Pitch p);
	public void deletePitch(Pitch p);
	
}
