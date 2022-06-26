package com.sbj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDelimiter {

	public static void main(String[] args) {
		String LOG_ENTRY = "<PROCESS> <TrID:                               > <TID: 0000002181> <RPC ID: 0000000000> <Queue: Admin     > <Client-RPC: 390600   > <USER: AR_ESCALATOR                                 > <Overlay-Group: 1         > /* Wed Jun 22 2022 20:41:08.8960 */ --> Inputs: {addGroupNames=null, removeGroupNames=null, recordDefinitionName=com.bmc.arsys.rx.foundation:FoundationSYNC-AuditControl, removeRoleNames=null, addRoleNames=null, values={304434461=null, 304434401=Wed Jun 22 20:41:06 PDT 2022, 7=200, 304434411=null}, appendExistingValues=null, recordID=DIFFERENTIALCONROLRECORD, addUserNames=null, removeAll=null, removeFunctionalRoles=null, record=null, removeUserNames=null, addFunctionalRoles=null}";
		String REG_EX ="//*(.*)/*/";
		String entryMesgs[] = LOG_ENTRY.split(REG_EX);
		for(String msg : entryMesgs) {
			System.out.println(msg);
		}
		final String LOG_HEADER_MSG_REGEX = "<TrID:(.+?)> <TID:(.+?)> <RPC ID:(.+?)> <Queue:(.+?)> <Client-RPC:(.+?)> <USER:(.+?)> <Overlay-Group:(.+?)>";
		final Pattern LOG_HEADER_PATTERN = Pattern.compile(LOG_HEADER_MSG_REGEX);
		

		Matcher matcher = LOG_HEADER_PATTERN.matcher(entryMesgs[0]);
		while(matcher.find()) {
			String value = matcher.group(2).trim();
			if (value!=null) {
				System.out.println(value);
			}
			value = matcher.group(3).trim();
			if (value!=null) {
				System.out.println(value);
			}
			value = matcher.group(4).trim();
			if (value!=null) {
				System.out.println(value);
			}
			value = matcher.group(5).trim();
			if (value!=null) {
				System.out.println(value);
			}
			value = matcher.group(6).trim();
			if (value!=null) {
				System.out.println(value);
			}
			value = matcher.group(7).trim();
			if (value!=null) {
				System.out.println(value);
			}
			break;
		}
	
	}

}
