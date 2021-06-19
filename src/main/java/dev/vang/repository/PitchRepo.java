package dev.vang.repository;

import dev.vang.models.Pitch;

public interface PitchRepo {
	public Pitch getPitchById(Integer id);
	public void createPitch(Pitch p);
	public void updatePitch(Pitch p);
	public void deletePitch(Pitch p);
	
}
