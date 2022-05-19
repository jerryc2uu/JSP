package com.githrd.test.sql;

public class MemberSQL {
	
	public final int SEL_LOGIN_CNT = 1001;
	public final int SEL_MEMBER_INFO = 1002;
	public final int SEL_AVT_INFO = 1003;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND id = ? ");
			buff.append("	AND pw = ? ");
			break;
		case SEL_MEMBER_INFO:
			buff.append("SELECT ");
			buff.append("	mno, name, id, mail, tel, m.joindate, m.gen, savename ");
			buff.append("FROM ");
			buff.append("	MEMBER m, AVATAR a ");
			buff.append("WHERE ");
			buff.append("	m.avt = a.ano ");
			buff.append("	AND m.isshow = 'Y' ");
			buff.append("	AND id = ? ");
			break;
		case SEL_AVT_INFO:
			buff.append("SELECT ");
			buff.append("	ano, savename, dir, gen ");
			buff.append("FROM ");
			buff.append("	avatar ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND ano = ? ");
			break;
		}
		return buff.toString();
	}
}
