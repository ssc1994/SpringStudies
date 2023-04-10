package com.simple.basic.config;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidVO {
	/*
	 * @NotNull - Null값만 허용하지 않음			(Wrapper의 Integer, Long, String 등에 적용)
	 * @NotBlank - 공백 + Null값을 허용하지 않음	(String에만 적용)
	 * @NotEmpty - Null값을 허용하지 않음 (Array, list적용)
	 * 
	 * @Pattern - 정규표현식에 맞는 문자열을 정의할 수 있음 (String에만 적용가능)
	 * @Email - 이메일형식검증(공백은 통과)
	 * @Min - 최소값
	 * @Max - 최대값
	 */
	@NotBlank(message = "이름은 필수 입니다")
	private String name;
	
	//숫자, 실수형의 원시타입은 기본값이 0이라서 공백맵핑이 불가능하기때문에 래퍼타입으로 선언하는 편이 좋다.
	@NotNull(message = "급여는 필수 입니다")
	private Integer salary;
	
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호 형식은 000-0000-0000입니다")
	private String phone;
	
	@NotBlank	//두개 동시에 적용
	@Email(message = "email형식 이어야 합니다")		//email형식이어야한다. 단 공백은 통과
	private String email;
}
