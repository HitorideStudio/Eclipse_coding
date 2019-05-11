package test.ex.validate;

public class TestVo {
	private String id;
	private int age;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		//id = 알파벳으로만 이루어진 문자만 허용
		this.id = id;
		for(int i =0 ; i < id.length(); i++) {
			char c =id.charAt(i);
			if( !(c>= 65 && c <=122)) {
				this.id = "guest";
				break;
			}
		}
		
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age > 0 && age < 150) {
			this.age = age;
		}else {
			this.age = 1;
		}
		
	}
	

}
