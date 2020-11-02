package ProjectForm;

/**
 * <b>Cercle est la classe hérité de forme et représente la figure éponyme.
 * <p>
 * Un cercle est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un rayon.</li>
 * </ul>
 * </p>
 */
public class Cercle extends Ellipse{

	/**
	 * Constructeur Cercle à 4 paramètres
	 * @param x
	 * 			La coordonnée du centre du Cercle selon x hérité de Forme.
	 * @param y
	 * 			La coordonnée du centre du Cercle selon y hérité de Forme.
	 * @param couleur
	 * 			La couleur du Cercle hérité de Forme.
	 * @param rayon
	 * 			Le rayon du Cercle.
	 */
    public Cercle(final int x, final int y, final Couleur couleur, final int rayon1) {
    	super(x, y, couleur, rayon1, rayon1);
    }
    
    public Cercle(int x, int y) {
		super(x, y,Couleur.NOIR, 1, 1);

	}
    
    /**
	 * Constructeur Cercle à l'origine.
	 * <p>
	 * Le Cercle est construit à l'origine du repère en (0,0), est noir et son rayon vaut 1.
	 * </p>
	 */
    public Cercle() {
		this(0,0,Couleur.NOIR, 1);
	}
    //Methode
    /**
	 * Renvoie un nouveau cercle identique translatée
	 * 
	 * @param dx
	 * 			valeur de la translation selon l'axe horizontal x
	 * @param dy
	 * 			valeur de la translation selon l'axe vertical dy
	 * 
	 * @return les paramètres du nouveau cercle
	 */
	@Override
	public Cercle translation(int dx, int dy) {
		int transx =(int)this.centre.getX()+dx;
		
		int transy =(int)this.centre.getX()+dx;
		return new Cercle(transx, transy,this. couleur, this.rayon1);
	}
	
	/**
	 * Renvoie l'homothetie du cercle.
	 * 
	 * @param k
	 * 			le facteur de l'homothetie
	 * 
	 * @return les paramètres du nouveau cercle
	 */
	@Override
	public Cercle homothetie(int k) {
		return new Cercle((int)this.centre.getX()*k, (int)this.centre.getY()*k,this. couleur, this.rayon1*k);
	}

   
    /**
     * Renvoi les paramètres de ce cercle
     * 
     * @return Les paramètres de ce cercle, sous forme de chaîne de caractère.
     */
    @Override
    public String toString() {
        return "cercle " +this.couleur+ " de centre: " + centre + "et de rayon: " + getRayon1() ;
    }
}

