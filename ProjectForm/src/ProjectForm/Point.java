package ProjectForm;

/**
 * <b>Point est la classe représentant les coordonnées d'un point
 * <p>
 * Un point est caractérisé par les informations suivantes :
 * <ul>
 * <li>une coordonnée selon x.</li>
 * <li>une coordonnée selon y.</li>
 * </ul>
 * </p>
 */
public class Point {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	protected final double x;
	protected final double y;
	
	/**
	 * Constructeur Point à deux paramètres
	 * @param x
	 * 			La coordonnée du Point selon x
	 * @param y
	 * 			La coordonnée du Point selon y
	 */
	public Point(final int x, final int y){
		this.x = x;
		this.y = y;
	}
	
	public Point(final double x, final double y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructeur Point à l'origine.
	 * <p>
	 * Le point est construit à l'origine du repère en (0,0)
	 * </p>
	 */
	public Point() {
		this(0,0);

		/** A la place de
		this.x = 0;
		this.y = 0;
		 */
	}

	// Attention : final indique que la rÃ©fÃ©rence b est constante
	// "on ne peut pas changer de point" dans le corps de la mÃ©thode
	/**
	 * Constructeur Point de type copie.
	 * <p>
	 * Le constructeur créer un Point à partir d'un autre déja existant.
	 * </p>
	 * 
	 * @param b
	 * 			Le point déja existant servant de modèle.
	 */
	public Point(final Point b){
		this(b.x,b.y);

		/** A la place de
		this.x = b.x;
		this.y = b.y;
		 */
	}

	// ACCESSEURS EN LECTURE
	/**
	 * Retourne la coordonnée x du point.
	 * 
	 * @return La coordonnée selon x du Point, sous forme d'entier.
	 */
	public double getX() {
		return x;
	}


	/**
	 * Retourne la coordonnée y du point.
	 * 
	 * @return La coordonnée selon y du Point, sous forme d'entier.
	 */
	public double getY() {
		return y;
	}

	/** Un point est immutable donc pas d'accesseurs en Ã©criture
	public void setX(final int x) {
		this.x = x;
	}

	public void setY(final int y) {
		this.y = y;
	}
	 */

	/**
	 * Retourne la distance entre ce point et celui en paramètre.
	 * 
	 * @param p
	 * 			Le point à partir duquel on calcul a la distance de ce point.
	 * 
	 * @return La distance entre ce point et le point en paramètre, sous forme de double.
	 */
	public double distance(final Point p) {
		// les 2 lignes suivantes ne compilent pas!
		// Pourquoi final ....
		// p.x = 12;
		// p = new Point();
		/*	
		double a = ((this.x) - (p.x)) * ((this.x) - (p.x));
		double b = ((this.y) - (p.y)) * ((this.y) - (p.y));
		return Math.sqrt((a + b));
		 */	
		return Math.sqrt(((this.x) - (p.x)) * ((this.x) - (p.x)) + ((this.y) - (p.y)) * ((this.y) - (p.y)));
	}
	/**
	translation est une mÃ©thode dâ€™instance
	p1 antÃ©cÃ©dent en Maths
	p2 image en Maths (nouveau point)

	p2 = p1.translation(6, 2)Â ;

	p1 est immutable
	p2 aussi..

	en Maths
	translationÂ :   Points   ----â†’ Points
					P(x, y) |----â†’ Pâ€™(xâ€™, yâ€™)
	xâ€™ = x + dx;
	yâ€™ = y + dy;

    en Java : translation est une mÃ©thode dâ€™instance
	public Point translation(final int dx, final int dy){

	}
	 */
	// copie dÃ©fensive car point immutable
	/**
	 * Translate un point à une nouvelle position.
	 * 
	 * @param dx
	 * 			Valeur du déplacement du point selon x.
	 * @param dy
	 * 			Valeur du déplacement du point selon y.
	 * 
	 * @return Le Point translaté à sa nouvelle position.
	 */
	public Point translation(final int dx, final int dy) {
		return new Point(x + dx, y + dy);
	}

	/**
	pas d'annotation @Override
	==> tostring ERREUR NON DETECTEE
	la mÃ©thode toString n'est donc pas redÃ©finie!
	celle qui est activÃ©e est donc la mÃ©thode hÃ©ritÃ©e toString de la classe Object
	elle retourne l'identifiant unique de l'objet (instance)

	p1 = exo3.Point@4f023edb
	p2 = exo3.Point@3a71f4dd
	p3 = exo3.Point@7adf9f5f
	public String tostring(){
		return "(" + x + "," + y + ")";
	}
	 */

	/**
	tostring ERREUR DETECTEE grÃ¢ce Ã  l'annotation @Override
	NE COMPILE PAS avec le messsage d'erreur : 
	the method tostring() of type Point must override or implement a supertype method

	le supertype est le type Object qui implÃ©mente dÃ©jÃ  la mÃ©thode toString en retournant
	l'identifiant unique de l'objet (instance)
	Il faut donc la redÃ©finir(override) dans la classe Point sous-classe de Object

	@Override
	public String tostring(){
		return "(" + x + "," + y + ")";
	}
	 */

	/**
	 * Renvoi les coordonnées du point.
	 * 
	 * @return Les coordonnées du point, sous forme de chaîne de caractère.
	 */
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
