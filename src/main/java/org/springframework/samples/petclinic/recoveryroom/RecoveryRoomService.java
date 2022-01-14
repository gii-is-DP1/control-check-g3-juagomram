package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	@Autowired
	RecoveryRoomRepository recoveryRoomRepository;
	
	
    public List<RecoveryRoom> getAll(){
        List<RecoveryRoom> allRooms = recoveryRoomRepository.findAll();
        return allRooms;
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        RecoveryRoomType roomRecovered = recoveryRoomRepository.getRecoveryRoomType(typeName);
        return roomRecovered;
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        List<RecoveryRoom> roomsBiggerThanList = recoveryRoomRepository.findBySizeMoreThan(size);
        return roomsBiggerThanList;
    }

    public RecoveryRoom save(RecoveryRoom p) {
       RecoveryRoom recoveryRoom = recoveryRoomRepository.save(p);      
       return recoveryRoom;
    }

    
}
