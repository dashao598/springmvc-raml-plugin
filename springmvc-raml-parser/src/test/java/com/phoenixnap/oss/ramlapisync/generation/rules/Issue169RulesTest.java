package com.phoenixnap.oss.ramlapisync.generation.rules;

import org.junit.BeforeClass;
import org.junit.Test;

import com.phoenixnap.oss.ramlapisync.data.ApiResourceMetadata;
import com.phoenixnap.oss.ramlapisync.raml.InvalidRamlResourceException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

/**
 * @author aleksandars
 * @since 0.10.6
 */
public class Issue169RulesTest extends AbstractRuleTestBase {

	private Rule<JCodeModel, JDefinedClass, ApiResourceMetadata> rule;

	@BeforeClass
	public static void initRaml() throws InvalidRamlResourceException {
		AbstractRuleTestBase.RAML = RamlLoader.loadRamlFromFile(AbstractRuleTestBase.RESOURCE_BASE + "issue-169.raml");
	}

	@Test
	public void applySpring4ControllerStubRule_shouldCreate_validCode() throws Exception {

		rule = new Spring4ControllerStubRule();
		rule.apply(getControllerMetadata(), jCodeModel);
		String removedSerialVersionUID = removeSerialVersionUID(serializeModel());
		verifyGeneratedCode("Issue169Spring4ControllerStub", removedSerialVersionUID);
	}
}
