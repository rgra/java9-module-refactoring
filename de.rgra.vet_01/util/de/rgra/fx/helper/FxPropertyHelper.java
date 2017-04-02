package de.rgra.fx.helper;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.nio.channels.IllegalSelectorException;

import de.rgra.vet.pet.Pet;

/**
 * @author gransberger
 */
public class FxPropertyHelper {

	public static void main(String[] args) {
		final String LINE_BREAK = System.getProperty("line.separator");
		for (Field field : Pet.class.getDeclaredFields()) {
			forField(field, LINE_BREAK);
		}
	}

	private static void forField(Field field, final String LINE_BREAK) {
		String typeName = field.getType().getSimpleName();

		final String returnType;
		if (typeName.equals("StringProperty")) {
			returnType = "String";
		}
		else if (typeName.equals("LongProperty")) {
			returnType = "long";
		}
		else if (typeName.equals("IntegerProperty")) {
			returnType = "int";
		}
		else if (typeName.equals("BooleanProperty")) {
			returnType = "boolean";
		}
		else if (typeName.equals("ObjectProperty")) {
			ParameterizedType type = (ParameterizedType) field.getGenericType();
			Class<?> type2 = (Class<?>) type.getActualTypeArguments()[0];
			returnType = type2.getSimpleName();
			typeName = typeName + "<" + returnType + ">";
		}
		else {
			throw new IllegalSelectorException();
		}

		StringBuilder b = new StringBuilder();
		String varName = field.getName();
		String methodName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1).replace("Property", "");
		b.append("public " + typeName + " get" + methodName + "Property() {                ").append(LINE_BREAK);
		b.append("	return " + varName + ";                                    ").append(LINE_BREAK);
		b.append("}                                                       ").append(LINE_BREAK);
		b.append("                                                        ").append(LINE_BREAK);
		b.append("public " + returnType + " get" + methodName + "() {             ").append(LINE_BREAK);
		b.append("	return " + varName + ".get();                     ").append(LINE_BREAK);
		b.append("}                                                       ").append(LINE_BREAK);
		b.append("                                                        ").append(LINE_BREAK);
		b.append("public void set" + methodName + "(" + returnType + " value) {   ").append(LINE_BREAK);
		b.append("	" + varName + ".set(value);                       ").append(LINE_BREAK);
		b.append("}                                                       ").append(LINE_BREAK);
		System.out.println(b.toString());
	}
}
