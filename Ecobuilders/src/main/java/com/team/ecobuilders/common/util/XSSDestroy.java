package com.team.ecobuilders.common.util;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class XSSDestroy {

	// ������� �Է°����� ����� �±׿� �Ӽ��� ����
	private static final PolicyFactory policy = new HtmlPolicyBuilder()
			.allowElements("p", "b", "i", "u", "string", "em", "a", "img")
			.allowAttributes("href", "target", "class").onElements("a")
			.allowAttributes("src", "alt", "style", "width", "height", "class").onElements("img")
			.allowStandardUrlProtocols()
			.toFactory();
	
	// �Ķ���Ϳ� ���ڿ��� ������ �� ������ ������ �±� �� �Ӽ��� �ı��� ����� ����
	public static String destroy(String inputText) {
		return policy.sanitize(inputText);
	}
	
	
	
	
	
	
}
