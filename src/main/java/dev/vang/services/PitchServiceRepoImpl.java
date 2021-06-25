package dev.vang.services;

import dev.vang.models.Pitch;
import dev.vang.repository.PitchRepo;
import dev.vang.repository.PitchRepoImpl;

public class PitchServiceRepoImpl implements PitchServiceRepo {
	PitchRepo pr = new PitchRepoImpl();
	@Override
	public void updateAssistantApproval(Pitch p) {
		pr.updatePitch(p);
	}

}
