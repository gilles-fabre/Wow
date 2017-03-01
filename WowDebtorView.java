/*
                   GNU LESSER GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.


  This version of the GNU Lesser General Public License incorporates
the terms and conditions of version 3 of the GNU General Public
License, supplemented by the additional permissions listed below.

  0. Additional Definitions.

  As used herein, "this License" refers to version 3 of the GNU Lesser
General Public License, and the "GNU GPL" refers to version 3 of the GNU
General Public License.

  "The Library" refers to a covered work governed by this License,
other than an Application or a Combined Work as defined below.

  An "Application" is any work that makes use of an interface provided
by the Library, but which is not otherwise based on the Library.
Defining a subclass of a class defined by the Library is deemed a mode
of using an interface provided by the Library.

  A "Combined Work" is a work produced by combining or linking an
Application with the Library.  The particular version of the Library
with which the Combined Work was made is also called the "Linked
Version".

  The "Minimal Corresponding Source" for a Combined Work means the
Corresponding Source for the Combined Work, excluding any source code
for portions of the Combined Work that, considered in isolation, are
based on the Application, and not on the Linked Version.

  The "Corresponding Application Code" for a Combined Work means the
object code and/or source code for the Application, including any data
and utility programs needed for reproducing the Combined Work from the
Application, but excluding the System Libraries of the Combined Work.

  1. Exception to Section 3 of the GNU GPL.

  You may convey a covered work under sections 3 and 4 of this License
without being bound by section 3 of the GNU GPL.

  2. Conveying Modified Versions.

  If you modify a copy of the Library, and, in your modifications, a
facility refers to a function or data to be supplied by an Application
that uses the facility (other than as an argument passed when the
facility is invoked), then you may convey a copy of the modified
version:

   a) under this License, provided that you make a good faith effort to
   ensure that, in the event an Application does not supply the
   function or data, the facility still operates, and performs
   whatever part of its purpose remains meaningful, or

   b) under the GNU GPL, with none of the additional permissions of
   this License applicable to that copy.

  3. Object Code Incorporating Material from Library Header Files.

  The object code form of an Application may incorporate material from
a header file that is part of the Library.  You may convey such object
code under terms of your choice, provided that, if the incorporated
material is not limited to numerical parameters, data structure
layouts and accessors, or small macros, inline functions and templates
(ten or fewer lines in length), you do both of the following:

   a) Give prominent notice with each copy of the object code that the
   Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the object code with a copy of the GNU GPL and this license
   document.

  4. Combined Works.

  You may convey a Combined Work under terms of your choice that,
taken together, effectively do not restrict modification of the
portions of the Library contained in the Combined Work and reverse
engineering for debugging such modifications, if you also do each of
the following:

   a) Give prominent notice with each copy of the Combined Work that
   the Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the Combined Work with a copy of the GNU GPL and this license
   document.

   c) For a Combined Work that displays copyright notices during
   execution, include the copyright notice for the Library among
   these notices, as well as a reference directing the user to the
   copies of the GNU GPL and this license document.

   d) Do one of the following:

       0) Convey the Minimal Corresponding Source under the terms of this
       License, and the Corresponding Application Code in a form
       suitable for, and under terms that permit, the user to
       recombine or relink the Application with a modified version of
       the Linked Version to produce a modified Combined Work, in the
       manner specified by section 6 of the GNU GPL for conveying
       Corresponding Source.

       1) Use a suitable shared library mechanism for linking with the
       Library.  A suitable mechanism is one that (a) uses at run time
       a copy of the Library already present on the user's computer
       system, and (b) will operate properly with a modified version
       of the Library that is interface-compatible with the Linked
       Version.

   e) Provide Installation Information, but only if you would otherwise
   be required to provide such information under section 6 of the
   GNU GPL, and only to the extent that such information is
   necessary to install and execute a modified version of the
   Combined Work produced by recombining or relinking the
   Application with a modified version of the Linked Version. (If
   you use option 4d0, the Installation Information must accompany
   the Minimal Corresponding Source and Corresponding Application
   Code. If you use option 4d1, you must provide the Installation
   Information in the manner specified by section 6 of the GNU GPL
   for conveying Corresponding Source.)

  5. Combined Libraries.

  You may place library facilities that are a work based on the
Library side by side in a single library together with other library
facilities that are not Applications and are not covered by this
License, and convey such a combined library under terms of your
choice, if you do both of the following:

   a) Accompany the combined library with a copy of the same work based
   on the Library, uncombined with any other library facilities,
   conveyed under the terms of this License.

   b) Give prominent notice with the combined library that part of it
   is a work based on the Library, and explaining where to find the
   accompanying uncombined form of the same work.

  6. Revised Versions of the GNU Lesser General Public License.

  The Free Software Foundation may publish revised and/or new versions
of the GNU Lesser General Public License from time to time. Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

  Each version is given a distinguishing version number. If the
Library as you received it specifies that a certain numbered version
of the GNU Lesser General Public License "or any later version"
applies to it, you have the option of following the terms and
conditions either of that published version or of any later version
published by the Free Software Foundation. If the Library as you
received it does not specify a version number of the GNU Lesser
General Public License, you may choose any version of the GNU Lesser
General Public License ever published by the Free Software Foundation.

  If the Library as you received it specifies that a proxy can decide
whether future versions of the GNU Lesser General Public License shall
apply, that proxy's public statement of acceptance of any version is
permanent authorization for you to choose that version for the
Library.

Initial version by gilles fabre (gilles.fabre.perso@free.fr), March 2017
*/

package WowPackage;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Enumeration;
import java.util.Vector;
import java.lang.Math;

import javax.swing.JComponent;

/*
 * Created on Feb 24, 2005
 *
 * This modules defines the debtor view.
 */

/**
 * @author gilles.fabre
 *
 * @class WowDebtorView
 * 
 * this class defines a debtor view
 */
public final class WowDebtorView implements Comparable
{
	private String 			name;		
	private Rectangle  		rect;
	private Vector			debts;
	
	private	static	boolean layoutDone = false;
	private static Vector  	views = new Vector();
	private final static double PI = 3.14159;
	private final static double VIEW_SIZE = 70;
	private final static int 	ARROW_SIZE = 8;

	public	int getX() {return rect.x;}	
	public	int getY() {return rect.y;}
	public	void move(int x, int y) 
	{
		if (x >= 0)
			rect.x = x; 
		
		if (y >= 0)
			rect.y = y;
	}

	/**
	 * @author gilles.fabre
	 *
	 * @class WowDebtorViewLink
	 * 
	 * this class defines a debt link to a debtor view
	 */
	class WowDebtorViewLink
	{
		WowDebtorView 	whom;
		float 			what;
		
		WowDebtorViewLink(WowDebtorView _whom,  float _what)
		{
			whom = _whom;
			what = _what;
		}
	}
	
	public WowDebtorView(String _name) 
	{
		name = new String(_name);
		rect = new Rectangle(0, 0, (int)VIEW_SIZE, (int)VIEW_SIZE);
		debts = new Vector();
	}

	public WowDebtorView findView()
	{
		Enumeration e = views.elements();
		while (e.hasMoreElements())
		{
			WowDebtorView v = (WowDebtorView)e.nextElement();
			if (v.name.equals(name))
				return v;
		}

		return null;
	}
	
	static WowDebtorView findView(int x, int y)
	{
		Enumeration e = views.elements();
		while (e.hasMoreElements())
		{
			WowDebtorView v = (WowDebtorView)e.nextElement();
			if (v.rect.contains(x, y))
				return v;
		}

		return null;
	}

	public WowDebtorViewLink findLink(WowDebtorView linkTo)
	{
		Enumeration e = debts.elements();
		while (e.hasMoreElements())
		{
			WowDebtorViewLink v = (WowDebtorViewLink)e.nextElement();
			if (v.whom.name.equals(linkTo.name))
				return v;
		}

		return null;
	}
	
	public WowDebtorView addView()
	{
		WowDebtorView v = findView(); 
		if (v == null)
		{
			views.add(this);
			return this;
		}
		
		return v;
	}

	public int compareTo(Object o)
	{
		if (o.getClass() != this.getClass())
			throw new ClassCastException();
	
		WowDebtorView compareTo = (WowDebtorView)o;
		
		return compareTo.name.compareTo(name); 
	}
	
	public void addLink(WowDebtorView view, float what)
	{
		WowDebtorViewLink link = findLink(view);
		if (link == null)
			debts.add(new WowDebtorViewLink(view, what));
		else
			link.what += what;
	}
	
	public void paint(Graphics g)
	{
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint gray2blue = new GradientPaint(rect.x,
        										    rect.y,
													Color.gray,
													rect.x + rect.width, 
													rect.y + rect.height,
													Color.blue);

		// draw debtor...
		g2.setPaint(gray2blue);
		g2.fillArc(rect.x,
				   rect.y,
				   rect.width,
				   rect.height,
				   0,
				   360);
		
		// draw name centered and clipped...
		g2.setFont(new Font("Times new roman", java.awt.Font.PLAIN, 12));
		g2.setColor(Color.white);
		int x, y;
		x = rect.x + (rect.width >> 1);
		y = rect.y + (rect.height >> 1);
		x -= (g.getFontMetrics().stringWidth(name) >> 1);
		y += (g.getFontMetrics().getHeight() >> 1);
		Rectangle clipRect = new Rectangle(g2.getClipRect());
		g2.clipRect(rect.x + 1,
					rect.y + 1,
					rect.width - 1,
					rect.height - 1);
		g2.drawString(name, x, y);
		g2.setClip(clipRect);
	}

	private static int yCor(int len, double dir) {return (int)(len * Math.cos(dir));}
	private static int xCor(int len, double dir) {return (int)(len * Math.sin(dir));}

	private void drawArrow(Graphics2D g2d, int xCenter, int yCenter, int x, int y, float stroke, String text) 
	{
		double aDir = Math.atan2(xCenter - x, yCenter - y);
		int i1 = ARROW_SIZE + (int)(stroke * 2);
		int i2 = (ARROW_SIZE >> 1) + (int)stroke;			// make the arrow head the same size regardless of the length length
		x += xCor((int)(VIEW_SIZE) >> 1, aDir);
		y += yCor((int)(VIEW_SIZE) >> 1, aDir);
        
		GradientPaint green2red = new GradientPaint(xCenter,
												    yCenter,
												    Color.green,
												    x, 
												    y, 
												    Color.red);
		g2d.setPaint(green2red);
		g2d.setStroke(new BasicStroke(1f));					
		g2d.drawLine(x, y, xCenter, yCenter);

		Polygon tmpPoly = new Polygon();
		tmpPoly.addPoint(x, y);								// arrow tip
		tmpPoly.addPoint(x + xCor(i1, aDir+.5), y + yCor(i1, aDir+.5));
		tmpPoly.addPoint(x + xCor(i2, aDir), y + yCor(i2, aDir));
		tmpPoly.addPoint(x + xCor(i1, aDir-.5), y + yCor(i1, aDir-.5));
		tmpPoly.addPoint(x, y);								// arrow tip
		g2d.drawPolygon(tmpPoly);
		g2d.fillPolygon(tmpPoly);

		if (text != null)
		{
			g2d.setColor(Color.black);
			g2d.setFont(new Font("Times new roman", java.awt.Font.BOLD | java.awt.Font.ITALIC, 12));
			int textX = x + xCor((int)(VIEW_SIZE) >> 1, aDir);
			int textY = y + yCor((int)(VIEW_SIZE) >> 1, aDir);
			g2d.drawString(text, textX, textY);					
		}
	}
	
	public void paintLinks(Graphics g)
	{
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// draw links.
		Enumeration e = debts.elements();
		while (e.hasMoreElements())
		{
			int x1, x2, y1, y2;
			
			WowDebtorViewLink link = (WowDebtorViewLink)e.nextElement();

			x1 = rect.x + (rect.width >> 1);
			y1 = rect.y + (rect.height >> 1);
			x2 = link.whom.rect.x + (link.whom.rect.width >> 1);
			y2 = link.whom.rect.y + (link.whom.rect.height >> 1);

			g.setColor(Color.blue);
			drawArrow(g2, x1, y1, x2, y2, 3, new Float(Math.round(link.what)).toString());
		}
	}

	static public void clearViews()
	{
		views.clear();
		layoutDone = false;
	}

	static public int numberOfViews()
	{
		return views.size();
	}
	
	static public void doLayout(JComponent client)
	{
		if (layoutDone)
		{
			Enumeration e = views.elements();
			int			minX = 0, minY = 0, maxX = 0, maxY = 0;
			while (e.hasMoreElements())
			{
				WowDebtorView view = (WowDebtorView)e.nextElement();
				if (view.rect.x < minX)
					minX = view.rect.x;
				if (view.rect.y < minY)
					minY = view.rect.y;
				if (view.rect.x + view.rect.width > maxX)
					maxX = view.rect.x + view.rect.width;
				if (view.rect.y + view.rect.height > maxY)
					maxY = view.rect.y + view.rect.height;
			}
	
			client.scrollRectToVisible(new Rectangle(minX, minY, maxX, maxY)); 
			client.setPreferredSize(new Dimension(maxX - minX, maxY - minY));
			client.revalidate();
		}
		else
		{
			double 		n = numberOfViews();
			double 		radius = (VIEW_SIZE * (n + 1)) / PI;
			double 		angle = 0, angleIncrement;
			
			Enumeration e = views.elements();
			angleIncrement = 360.0 / n;
			while (e.hasMoreElements())
			{
				WowDebtorView view = (WowDebtorView)e.nextElement();
				view.rect.x = (int)(Math.cos(Math.toRadians(angle)) * radius);  
				view.rect.y = (int)(Math.sin(Math.toRadians(angle)) * radius);
				view.rect.x += (int)radius;
				view.rect.y += (int)radius;
				angle += angleIncrement;
			}
	
			client.scrollRectToVisible(new Rectangle(0, 0, (int)((radius * 2) + VIEW_SIZE), (int)((radius * 2) + VIEW_SIZE))); 
			client.setPreferredSize(new Dimension((int)((radius * 2) + VIEW_SIZE), (int)((radius * 2) + VIEW_SIZE)));
			client.revalidate();
		}
		
		layoutDone = true;
	}
	
	public static void paintViews(Graphics g)
	{
		Enumeration e = views.elements();
		while (e.hasMoreElements())
		{
			WowDebtorView view = (WowDebtorView)e.nextElement();
			view.paintLinks(g);
		}

		e = views.elements();
		while (e.hasMoreElements())
		{
			WowDebtorView view = (WowDebtorView)e.nextElement();
			view.paint(g);
		}
	}
}
