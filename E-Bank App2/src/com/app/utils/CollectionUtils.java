package com.app.utils;

import static com.app.utils.ValidationRules.validateAllInputs;

import java.util.HashMap;

import com.app.account.Account;
import com.app.exceptions.AccountHandlingException;

public class CollectionUtils {

	public static HashMap<Integer, Account> populateSampleData() throws AccountHandlingException {
		HashMap<Integer, Account> map = new HashMap<>();
		Account acc = validateAllInputs(map,"Sharad", "sharad.6030@gmail.com", "7387858637", 50000, "CURRENT");
		map.put(acc.getAccNumber(), acc);

	    acc = validateAllInputs(map, "Anita", "anita.6030@gmail.com", "7775870608", 60000, "SAVING");
		map.put(acc.getAccNumber(), acc);

	    acc = validateAllInputs(map,"Priyanka", "priyanka.kedar@gmail.com", "9763173013", 500000, "CURRENT");
		map.put(acc.getAccNumber(), acc);

		acc = validateAllInputs(map,"Anilkadam", "anil.kadam@gmail.com", "9970053448", 80000, "SAVING");
		map.put(acc.getAccNumber(), acc);

		acc = validateAllInputs(map, "Harshu", "harsh.6030@gmail.com", "7249230333", 506000, "CURRENT");
		map.put(acc.getAccNumber(), acc);

		acc = validateAllInputs(map, "Sharad", "sharad.6030@gmail.com", "7249230333", 506000, "SAVING");
		map.put(acc.getAccNumber(), acc);

		return map;

	}
}
