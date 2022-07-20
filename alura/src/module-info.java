module alura {
	requires java.net.http;
	requires com.fasterxml.jackson.databind;
	requires java.desktop;
	opens com.alura.aula to com.fasterxml.jackson.databind;
}