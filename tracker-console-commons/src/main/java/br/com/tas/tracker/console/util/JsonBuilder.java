package br.com.tas.tracker.console.util;
import java.util.Stack;

public class JsonBuilder {
	private final StringBuilder builder;
	private final Stack<Boolean> escopoComValores;

	public JsonBuilder() {
		builder = new StringBuilder(20480);
		escopoComValores = new Stack<Boolean>();
		escopoComValores.push(false);
	}

	@Override
	public String toString() {
		return builder.toString();
	}

	public JsonBuilder limpar() {
		builder.delete(0, builder.length());
		escopoComValores.clear();
		escopoComValores.push(false);
		return this;
	}

	public JsonBuilder array() {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		escopoComValores.push(false);
		builder.append('[');
		return this;
	}

	public JsonBuilder array(String nome) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		escopoComValores.push(false);
		builder.append('\"');
		builder.append(nome);
		builder.append("\":[");
		return this;
	}

	public JsonBuilder fimArray() {
		escopoComValores.pop();
		builder.append(']');
		return this;
	}

	public JsonBuilder objeto() {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		escopoComValores.push(false);
		builder.append('{');
		return this;
	}

	public JsonBuilder objeto(String nome) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		escopoComValores.push(false);
		builder.append('\"');
		builder.append(nome);
		builder.append("\":{");
		return this;
	}

	public JsonBuilder fimObjeto() {
		escopoComValores.pop();
		builder.append('}');
		return this;
	}

	public JsonBuilder propRaw(String nome, String valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append('\"');
		builder.append(nome);
		if (valor == null) {
			builder.append("\":null");
		} else {
			builder.append("\":");
			builder.append(valor);
		}
		return this;
	}

	public JsonBuilder prop(String nome, String valor) {
		return prop(nome, valor, false);
	}
	
	public JsonBuilder prop(String nome, String valor, boolean stringSegura) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append('\"');
		builder.append(nome);
		if (valor == null) {
			builder.append("\":null");
		} else {
			builder.append("\":\"");
			// Depois de muito pensar, visto que replace retorna a mesma String caso nada seja alterado,
			// e visto que, em nosso cen�rio, os tr�s caracteres abaixo s�o muito pouco utilizados,
			// decidi deixar dessa forma, em vez de varrer a String toda e chamar append(char)
			// https://referencesource.microsoft.com/#mscorlib/system/String.cs
			// https://referencesource.microsoft.com/#mscorlib/system/text/stringbuilder.cs
			builder.append(stringSegura ? valor : valor.replace("\\", "\\\\").replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n").replace('\0', ' '));
			builder.append('\"');
		}
		return this;
	}

	public JsonBuilder prop(String nome, boolean valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append('\"');
		builder.append(nome);
		builder.append("\":");
		builder.append(valor ? "true" : "false");
		return this;
	}

	public JsonBuilder prop(String nome, int valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append('\"');
		builder.append(nome);
		builder.append("\":");
		builder.append(valor);
		return this;
	}

	public JsonBuilder prop(String nome, long valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append('\"');
		builder.append(nome);
		builder.append("\":");
		builder.append(valor);
		return this;
	}

	public JsonBuilder prop(String nome, float valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append('\"');
		builder.append(nome);
		builder.append("\":");
		builder.append(valor);
		return this;
	}

	public JsonBuilder prop(String nome, double valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append('\"');
		builder.append(nome);
		builder.append("\":");
		builder.append(valor);
		return this;
	}
	
	public JsonBuilder valorRaw(String valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append((valor == null) ? "null" : valor);
		return this;
	}

	public JsonBuilder valor(String valor) {
		return valor(valor, false);
	}
	
	public JsonBuilder valor(String valor, boolean stringSegura) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		// Depois de muito pensar, visto que replace retorna a mesma String caso nada seja alterado,
		// e visto que, em nosso cen�rio, os tr�s caracteres abaixo s�o muito pouco utilizados,
		// decidi deixar dessa forma, em vez de varrer a String toda e chamar append(char)
		// https://referencesource.microsoft.com/#mscorlib/system/String.cs
		// https://referencesource.microsoft.com/#mscorlib/system/text/stringbuilder.cs
		builder.append('\"');
		builder.append((valor == null) ? "null" : (stringSegura ? valor : valor.replace("\\", "\\\\").replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n").replace('\0', ' ')));
		builder.append('\"');
		return this;
	}

	public JsonBuilder valor(boolean valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append(valor ? "true" : "false");
		return this;
	}

	public JsonBuilder valor(int valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append(valor);
		return this;
	}

	public JsonBuilder valor(long valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append(valor);
		return this;
	}

	public JsonBuilder valor(float valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append(valor);
		return this;
	}

	public JsonBuilder valor(double valor) {
		if (escopoComValores.peek()) {
			// Se esse n�o � o primeiro objeto desse escopo (array ou objeto),
			// adiciona uma v�rgula para separar
			builder.append(',');
		} else {
			// Se esse era o primeiro objeto do escopo, apenas indica que
			// agora j� existe algu�m, para que os pr�ximos adicionem uma v�rgula
			escopoComValores.pop();
			escopoComValores.push(true);
		}
		builder.append(valor);
		return this;
	}
}
