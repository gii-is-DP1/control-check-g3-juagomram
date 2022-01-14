package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import antlr.collections.List;

@Controller
public class RecoveryRoomController {
	
	@Autowired
	RecoveryRoomService recoveryRoomService;
	
	
	@GetMapping("recoveryroom/create")
	public String formApartado9(ModelMap modelMap) {
		String view = "recoveryroom/createOrUpdateRecoveryRoomForm";
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		modelMap.put("recoveryRoom", recoveryRoom);
		modelMap.put("types", recoveryRoomService.getAllRecoveryRoomTypes());
		return view;
	}
	
	@PostMapping("recoveryroom/create")
	public String formApartado10(@Valid RecoveryRoom recoveryRoom, BindingResult result,ModelMap modelMap) {
		String view = "/welcome";
		if(result.hasErrors()) {
			modelMap.put("recoveryRoom", recoveryRoom);
			modelMap.put("types", recoveryRoomService.getAllRecoveryRoomTypes());
			return "recoveryroom/create";
		} else {
			recoveryRoomService.save(recoveryRoom);
			
		}
		return view;
	}
    
}
