package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

	@Autowired
	RecoveryRoomService roomService;
	
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        String nombre = object.getName();
        return nombre;
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	RecoveryRoomType recoveredRoomType = roomService.getRecoveryRoomType(text);
    	if(recoveredRoomType == null) {
    		throw new ParseException(text + "Is null so can´t be parsed", 0);
    	} else {
    		return recoveredRoomType;
    	}
    }
    
}
