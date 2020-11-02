package ProjectForm;

/**
 * <b>Cercle est la classe h�rit� de forme et repr�sente la figure �ponyme.
 * <p>
 * Un cercle est caract�ris� par les informations suivantes :
 * <ul>
 * <li>Un rayon.</li>
 * </ul>
 * </p>
 */
public class Cercle extends Ellipse{

	/**
	 * Constructeur Cercle � 4 param�tres
	 * @param x
	 * 			La coordonn�e du centre du Cercle selon x h�rit� de Forme.
	 * @param y
	 * 			La coordonn�e du centre du Cercle selon y h�rit� de Forme.
	 * @param couleur
	 * 			La couleur du Cercle h�rit� de Forme.
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
	 * Constructeur Cercle � l'origine.
	 * <p>
	 * Le Cercle est construit � l'origine du rep�re en (0,0), est noir et son rayon vaut 1.
	 * </p>
	 */
    public Cercle() {
		this(0,0,Couleur.NOIR, 1);
	}
    //Methode
    /**
	 * Renvoie un nouveau cercle identique translat�e
	 * 
	 * @param dx
	 * 			valeur de la translation selon l'axe horizontal x
	 * @param dy
	 * 			valeur de la translation selon l'axe vertical dy
	 * 
	 * @return les param�tres du nouveau cercle
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
	 * @return les param�tres du nouveau cercle
	 */
	@Override
	public Cercle homothetie(int k) {
		return new Cercle((int)this.centre.getX()*k, (int)this.centre.getY()*k,this. couleur, this.rayon1*k);
	}

   
    /**
     * Renvoi les param�tres de ce cercle
     * 
     * @return Les param�tres de ce cercle, sous forme de cha�ne de caract�re.
     */
    @Override
    public String toString() {
        return "cercle " +this.couleur+ " de centre: " + centre + "et de rayon: " + getRayon1() ;
    }
}

