package net.serveron.sato.util;

public class StringUtil {
	
	/***
	 *　文字列チェック.
	 * NULL又は空文字の場合TRUEを返却する
	 * @param param
	 * @return boolean
	 */
	public static boolean isNull(String param){
		if (param == null || "".equals(param)){
			return true;
		}else{
			return false;
		}
	}
}
