package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/*
 * Permite construir una instancia del WallpostImpl.
 * Luego de la invocación, debe tener como texto: “Undefined post”,
 * no debe estar marcado como destacado y la cantidad de “Me gusta” debe ser 0.
 */
public class WallPostImpl implements WallPost {
	/**
	 * Complete con su implementación
	 */
	private String text;
	private int likes;
	private boolean featured;

	public WallPostImpl() {
		this.text = "Undefined post";
		this.likes = 0;
		featured = false;
	}

	/*
	 * Retorna el texto descriptivo de la publicación
	 */
	@Override
	public String getText() {
		return this.text;
	}

	/*
	 * Asigna el texto descriptivo de la publicación
	 */
	@Override
	public void setText(String text) {
		this.text = text;
	}

	/*
	 * Retorna la cantidad de “me gusta”
	 */
	@Override
	public int getLikes() {
		return this.likes;
	}

	/*
	 * Incrementa la cantidad de likes en uno.
	 */
	@Override
	public void like() {
		this.likes++;
	}

	/*
	 * Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada.
	 */
	@Override
	public void dislike() {
		this.likes = (this.likes == 0) ? 0 : this.likes - 1;
	}

	/*
	 * Retorna true si el post está marcado como destacado, false en caso contrario
	 */
	@Override
	public boolean isFeatured() {
		return this.featured;
	}

	@Override
	public void toggleFeatured() {
		this.featured = !this.featured;
	}

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
	@Override
	public String toString() {
		return "WallPost {" +
				"text: " + getText() +
				", likes: '" + getLikes() + "'" +
				", featured: '" + isFeatured() + "'" +
				"}";
	}
}
