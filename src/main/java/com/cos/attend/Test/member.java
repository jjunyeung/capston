package com.cos.attend.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class member {
	private  int id;
	private  String username;
	private  String password;
	private  String email;
}
