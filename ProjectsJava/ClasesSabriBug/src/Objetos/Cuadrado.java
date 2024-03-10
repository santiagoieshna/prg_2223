package Objetos;

public class Cuadrado {
	
	private Float lado1;
	private Float lado2;
	private Float lado3;
	public Float lado4;
	private String color;
	
	
	/**
	 * Metodo constructor, que es el que inicializa la instancia cuando se construye ( new la construye)
	 */
	public Cuadrado() {
		lado1 = 0f;
		lado2 = 0f;
		lado3 = 0f;
		lado4 = 0f;
		color = "Amarillo";
	}
	

	public Cuadrado(Float lado1, Float lado2, Float lado3, Float lado4, String color) {
		super();
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
		this.lado4 = lado4;
		this.color = color;
	}

	public Float obtenerLado2() {
		return getLado2();
	}

	public Float getLado1() {
		return lado1;
	}

	public void setLado1(Float lado1) {
		this.lado1 = lado1;
	}

	private Float getLado2() {
		return lado2;
	}

	public void setLado2(Float lado2) {
		this.lado2 = lado2;
	}

	public Float getLado3() {
		return lado3;
	}

	public void setLado3(Float lado3) {
		this.lado3 = lado3;
	}

	public Float getLado4() {
		return lado4;
	}

	public void setLado4(Float lado4) {
		this.lado4 = lado4;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	} 
	
	
	
	
	
	
}
