package com.lanyan.common;

import java.util.Collection;

public interface PersistentEnum {
	String getName();
	String getDescript();
	PersistentEnum getFromName(String name);
	Collection<PersistentEnum> getAllInstance();
}
