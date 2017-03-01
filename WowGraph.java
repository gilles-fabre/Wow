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
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;
/*
 * Created on Feb 18, 2005
 *
 * This module handles the Wow graph and its solution (transitive closure)
 * 
 */

/**
 * @author gilles.fabre
 *
 * @class WowGraph
 * 
 * this class handles the Wow graph. It supports adding/removing Wow data and solving
 * the wow problem. When adding or removing wow data, a tree receives the debtors while 
 * the groups are created in a separate vector. The 'solve' method can be invoked to 
 * solve the wow problem.
 * 
 */

public final class WowGraph extends TreeSet 
{
	private Vector 	groups = new Vector();
	private WowLog	log;
	
	public WowGraph(WowLog _log) {log = _log;}
	
	public final class Debt
	{
		public float 	what;
		public String 	whom;
		private boolean whomIsPerson;
		
		public Debt(String _whom, float _what, boolean _whomIsPerson)
		{
			whom = new String(_whom);
			what = _what;
			whomIsPerson = _whomIsPerson;
		}
	}
	
	private final class Group implements Comparable
	{
		private String 	name;
		private Vector	individuals;
		
		Group(String _name)
		{
			name = new String(_name);	
			individuals = new Vector();
		}

		void addIndividual(String _who)
		{
			individuals.add(new String(_who));
		}

		String findIndividual(String _who)
		{
			Enumeration e = individuals.elements();
			
			while (e.hasMoreElements())
			{
				String who = (String)e.nextElement();
				
				if (who.equals(_who))
					return who;
			}
			
			return null;
		}

		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Object o) 
		{
			if (o.getClass() != this.getClass())
				throw new ClassCastException();
		
			Group compareTo = (Group)o;
			
			return name.compareTo(compareTo.name); 
		}
	}
	
	final class Debtor implements Comparable
	{
		private String 	who;
		private Vector	debts;
		private boolean isPerson;
		
		Debtor(String _who, float _what, String _whom, boolean _isPerson, boolean _whomIsPerson)
		{
			who = new String(_who);	
			debts = new Vector();
			debts.add(new Debt(_whom, _what, _whomIsPerson));
			isPerson = _isPerson;
		}
		
		Debtor(String _who)
		{
			who = new String(_who);	
			debts = new Vector();
			isPerson = true; 
		}

		Debt addDebt(float _what, String _whom, boolean _whomIsPerson)
		{
			Debt newDebt = new Debt(_whom, _what, _whomIsPerson); 
			debts.add(newDebt);
			return newDebt;
		}
		
		void removeDebt(Debt debt)
		{
			debts.remove(debt);
		}
		
		Debt findDebt(String _whom)
		{
			Enumeration e = debts.elements();
			
			while (e.hasMoreElements())
			{
				Debt debt = (Debt)e.nextElement();
				
				if (debt.whom.equals(_whom))
					return debt;
			}
			
			return null;
		}
		
		Enumeration getDebts()
		{
			return debts.elements();
		}
		
		// data node key is the who info... because all nodes represent
		// who OWES whom data.
		public int compareTo(Object o)
		{
			if (o.getClass() != this.getClass())
				throw new ClassCastException();
		
			Debtor compareTo = (Debtor)o;
			
			return compareTo.who.compareTo(who); 
		}

		public String getWho() 
		{
			return who;
		}
	}
	
	// return the object that contains the who element, null else
	Debt findDebt(String who, String whom)
	{
		Debtor temp = findDebtor(who);
		
		if (temp == null)
			return null;
		
		return temp.findDebt(whom);
	}
	
	// return the object that contains the who element, null else
	Debtor findDebtor(String who)
	{
		Iterator i = iterator();
		while (i.hasNext())
		{
			Debtor d = (Debtor)i.next();
			if (d.who.equals(who))
				return d;
		}

		return null;
	}
	
	// return the object that which name starts with prefix, null else
	public Debtor findDebtorStartingWith(String prefix)
	{
		Iterator i = iterator();
		while (i.hasNext())
		{
			Debtor d = (Debtor)i.next();
			if (d.who.startsWith(prefix))
				return d;
		}

		return null;
	}

	void removeDebtor(Debtor debtor)
	{
		remove(debtor);
	}

	Group findGroup(String _name)
	{
		Enumeration e = groups.elements();
		
		while (e.hasMoreElements())
		{
			Group group = (Group)e.nextElement();
			
			if (group.name.equals(_name))
				return group;
		}
		
		return null;
	}
	
	Group pertainToGroup(String who)
	{
		Enumeration e = groups.elements();
		
		while (e.hasMoreElements())
		{
			Group group = (Group)e.nextElement();
			
			if (group.findIndividual(who) != null)
				return group;
		}
		
		return null;
	}

	void addGroup(String _name)
	{
		groups.add(new Group(_name));
	}

	void addData(String who, String does, float what, String whom)
	{
		// creating a new group?
		if (does.equals(Messages.getString("WowEntry.17"))) // pertain
		{
			Group group;
			
			// who pertain to group whom
			if ((group = findGroup(whom)) == null)
			{
				addGroup(whom);
				group = findGroup(whom);
			}
			
			group.addIndividual(who);

			return;
		}

		if (does.equals(Messages.getString("WowEntry.10")) ||  // use
			does.equals(Messages.getString("WowEntry.6"))  ||  // owe
			does.equals(Messages.getString("WowEntry.16")))    // borrow
		{
			Debt debt = findDebt(who, whom);
			if (debt != null)
				debt.what += what;
			else
			{
				Debtor debtor = findDebtor(who);
				if (debtor != null)
					debtor.addDebt(what, 
								   whom, 
								   !does.equals(Messages.getString("WowEntry.10"))); // whom is not a person if and only if who *use* what 
				else
					add(new Debtor(who, 
								   what, 
								   whom, 
								   true, // who is ALWAYS a person here
								   !does.equals(Messages.getString("WowEntry.10")))); // whom is not a person if and only if who *use* what 

				if (findDebtor(whom) == null)
					add(new Debtor(whom));
			}
		}
		else if (does.equals(Messages.getString("WowEntry.7")) ||	// pay
				 does.equals(Messages.getString("WowEntry.8")) || 	// lend
				 does.equals(Messages.getString("WowEntry.9")))   	// refund
		{
			Debt debt = findDebt(whom, who);
			if (debt != null)
				debt.what += what;
			else
			{
				Debtor debtor = findDebtor(whom);
				if (debtor != null)
					debtor.addDebt(what, 
								   who, 
								   true); // whom (who) is ALWAYS a person here  
				else
					add(new Debtor(whom, 
								   what, 
								   who, 
								   !does.equals(Messages.getString("WowEntry.7")),    // who (whom) is person? 
								   true)); // whom (who) is ALWAYS a person here  

				if (findDebtor(who) == null)
					add(new Debtor(who));
			}
		}
	}

	/**
	 * 
	 * NOTE: this cleans the resolution log!
	 */
	public void updateData(WowTable table)
	{
		WowDebtorView.clearViews();
		clear();			// clear debts
		groups.clear();		// clear groups
		log.clear();		// clear log
		
		for (int i = 0; i < table.getRowCount(); i++)
		{
			addData((String)table.getValueAt(i, WowTable.WHO_COLUMN),
					(String)table.getValueAt(i, WowTable.DOES_COLUMN),
					((Float)(table.getValueAt(i, WowTable.WHAT_COLUMN))).floatValue(),
					(String)table.getValueAt(i, WowTable.TO_FOR_COLUMN));
		}
	}
	
	public void updateTable(WowTable table)
	{
		table.clear(); 
		
		Iterator i = iterator();
		int	row = 0;
		while (i.hasNext())
		{
			Debtor x = (Debtor)i.next();
			Enumeration elements = x.getDebts();
			while (elements.hasMoreElements())
			{
				Debt x2yDebt = (Debt)elements.nextElement();
				
				table.setValueAt(x.who, row, WowTable.WHO_COLUMN);
				table.setValueAt(Messages.getString("WowEntry.6"), row, WowTable.DOES_COLUMN);
				table.setValueAt(x2yDebt.whom, row, WowTable.TO_FOR_COLUMN);
				table.setValueAt(new Float(x2yDebt.what), row, WowTable.WHAT_COLUMN);

				DateFormat 	dateFmt = new SimpleDateFormat();
				table.setValueAt(dateFmt.format(new Date()), row, WowTable.WHEN_COLUMN);
				
				++row;
			}
		}
	}

	public void updateGraphView()
	{
		WowDebtorView.clearViews();
		
		Iterator i = iterator(); 
		while(i.hasNext())
		{
			Debtor debtor = (Debtor)i.next();
			WowDebtorView view = new WowDebtorView(debtor.who);
			view = view.addView();

			Enumeration e = debtor.getDebts();
			while (e.hasMoreElements())
			{
				Debt x2yDebt = (Debt)e.nextElement();
				WowDebtorView whomView = new WowDebtorView(x2yDebt.whom);
				whomView = whomView.addView();
				view.addLink(whomView, x2yDebt.what);
			}
		}
	}
	
	String getWho(int i) 
	{
		Object[] wowArray = toArray();
		return ((Debtor)(wowArray[i])).who; 
	}
	
	public void sanitize()
	{
		log.appendText("\n-------- Sanitizing Debts ---------------", Color.blue, true);
		
		Iterator i = iterator();
		while (i.hasNext())
		{
			Debtor x = (Debtor)i.next();
			Enumeration elements;

			elements = x.getDebts();
			while (elements.hasMoreElements())
			{
				Debt d = (Debt)elements.nextElement(); 
				if (d.what == 0 || d.whom.equals(x.who))
				{
					log.appendText("removing empty debt " + x.who + "-<" + d.what + ">->" + d.whom, Color.red, false);
					x.removeDebt(d);
				}
				else if (d.what < 0)
				{	
					log.appendText("reverting negative debt " + x.who + "-<" + d.what + ">->" + d.whom, Color.black, false);

					Debtor t;
					if ((t = findDebtor(d.whom)) != null)
					{
						Debt newDebt; 
						if ((newDebt = t.findDebt(x.who)) != null)
							newDebt.what -= d.what;
						else
							t.addDebt(-d.what, d.whom, d.whomIsPerson);
						
						removeDebtor(t);
					}
					else
					{
						add(new Debtor(d.whom, 
								       -d.what, 
									   x.who, 
									   d.whomIsPerson, 
									   x.isPerson));
					}
					
					x.removeDebt(d);
				}
			}

			if  (!x.getDebts().hasMoreElements())
			{
				log.appendText("removing empty (no debt) debtor " + x.who, Color.red, false);

				removeDebtor(x);
				i = iterator();
			}
		}
	}
	
	private float sumUsages(String product)
	{
		float sum = 0;

		Iterator i = iterator(); 
		while (i.hasNext())
		{
			Debtor debtor = (Debtor)i.next();

			Enumeration e = debtor.getDebts();
			while (e.hasMoreElements())
			{
				Debt x2yDebt = (Debt)e.nextElement();
				if (!x2yDebt.whomIsPerson && x2yDebt.whom.equals(product))
					sum += x2yDebt.what;
			}
		}
		
		return sum;
	}
	
	private void changeUsagesIntoDebts(String who, String p, float usageRatio)
	{
		Debtor w_debtor = findDebtor(who);
		Debtor p_debtor = findDebtor(p);
		
		if (p_debtor == null || w_debtor == null)
			return;
		
		// go through all the folks who paid for p...
		Enumeration e = p_debtor.getDebts();
		while (e.hasMoreElements())
		{
			Debt y2pDebt = (Debt)e.nextElement();

			// turn x - use -> p and y -pay for-> p into x - owe -> y
			Debt x2yDebt = w_debtor.findDebt(y2pDebt.whom);
			
			// skip x -> x for p
			if (who.equals(y2pDebt.whom))
				continue;
			
			if (x2yDebt != null)
			{
				x2yDebt.what += (y2pDebt.what * usageRatio);
				log.appendText(who + "-<" + (y2pDebt.what * usageRatio) + ">->" + y2pDebt.whom + " for " + p, Color.green, false);
			}
			else
			{
				w_debtor.addDebt(y2pDebt.what * usageRatio, y2pDebt.whom, true);
				log.appendText(who + "-<" + (y2pDebt.what * usageRatio) + ">->" + y2pDebt.whom + " for " + p, Color.green, false);
			}
		}
	}

	private void convertUsagesIntoDebts()
	{
		log.appendText("\n----- Converting Usages Into Debts ------", Color.blue, true);

		// x -(use n)-> p / y -(pay z)-> p :=> x -((n/sigma n) * p)-> y
		Iterator i = iterator();
		for(;;)
		{
			if (!i.hasNext())
				break;
			
			// get a valid x.
			Debtor x = (Debtor)i.next();
			
			// iterate through all x.debts and look for product being used.
			Enumeration elements = x.getDebts();
			while (elements.hasMoreElements())
			{
				Debt x2yDebt = (Debt)elements.nextElement();
				if (!x2yDebt.whomIsPerson)
				{
					// got p, sum all usages for p.
					float f = sumUsages(x2yDebt.whom);
					changeUsagesIntoDebts(x.who, x2yDebt.whom, x2yDebt.what / f);
				}
			}
		}
	}

	private void removeUsagesAndPayments()
	{
		boolean wasAction = false;

		log.appendText("\n----- Removing Usages and Payments ------", Color.blue, true);

		Iterator i = iterator();
		for(;;)
		{
			if (wasAction)
			{
				i = iterator();
				wasAction = false;
			}

			if (!i.hasNext())
				break;
			
			// get a product usage.
			Debtor 	x = (Debtor)i.next();
			if (!x.isPerson)
			{
				log.appendText("removing product " + x.who, Color.red, false);
				removeDebtor(x);
				wasAction = true;
			}
			else
			{
				Enumeration e = x.getDebts();
				while (!wasAction && e.hasMoreElements())
				{
					Debt d = (Debt)e.nextElement();
					
					if (!d.whomIsPerson)
					{
						log.appendText("removing usage " + x.who + "-<" + d.what + ">->" + d.whom, Color.red, false);
						x.removeDebt(d);
						wasAction = true;
					}
				}
			}
		}
	}

	// DON'T CALL TWICE per solve!!!!
	void generateGroupDebts()
	{
		log.appendText("\n----- Generating Group Debts ------", Color.blue, true);

		WowGraph originalSet = (WowGraph)clone();
		
		// iterate through all debtors/debts and generate debts accross the associated groups
		Iterator i = originalSet.iterator();
		for(;;)
		{
			if (!i.hasNext())
				break;
			
			// get a valid x.
			Debtor x = (Debtor)i.next();

			// does x pertain to a group?
			String who = x.who;
			Group whoGroup;
			if ((whoGroup = pertainToGroup(who)) != null)
				who = whoGroup.name;
			
			// for all x's debts generate a debt
			Enumeration elements = x.getDebts();
			while (elements.hasMoreElements())
			{
				Debt x2yDebt = (Debt)elements.nextElement();
				
				String whom = x2yDebt.whom;
				Group whomGroup;
				if ((whomGroup = pertainToGroup(whom)) != null)
					whom = whomGroup.name;
				
				// if no group or same group on both sides of the debt nothing to do.
				if ((whoGroup == null && whomGroup == null) || who.equals(whom))
					continue;
				
				// find who debtor, create it if it doesn't exist
				Debtor whoDebtor = findDebtor(who);
				if (whoDebtor == null)
				{
					log.appendText("creating debt " + who + "-<" + x2yDebt.what + ">->" + whom, Color.green, false);
					add(new Debtor(who, x2yDebt.what, whom, true, true));
				}
				else
				{
					Debt groupDebt = whoDebtor.findDebt(whom);
					if (groupDebt != null)
					{
						groupDebt.what += x2yDebt.what;
						log.appendText("increasing debt " + whoDebtor.who + "-<" + groupDebt.what + ">->" + groupDebt.whom, Color.black, false);
					}
					else
					{
						whoDebtor.addDebt(x2yDebt.what, whom, true);
						log.appendText("creating debt " + whoDebtor.who + "-<" + x2yDebt.what + ">->" + whom, Color.green, false);
					}
				}

				// find whom debtor, create it if it doesn't exist
				Debtor whomDebtor = findDebtor(whom);
				if (whomDebtor == null)
				{
					add(new Debtor(whom));
					log.appendText("creating debtor " + whom, Color.green, false);
				}
			}
		}
	}
	
	private void removeGroupedDebts()
	{
		log.appendText("\n----- Removing (to/from people) Grouped Debts ------", Color.blue, true);

		Iterator i = iterator();
		boolean wasAction = false;

		for(;;)
		{
			if (wasAction)
			{
				i = iterator();
				wasAction = false;
			}

			if (!i.hasNext())
				break;

			Debtor x = (Debtor)i.next();
			
			if (pertainToGroup(x.who) != null)
				i.remove();
			else
			{
				Enumeration elements = x.getDebts();
				while (!wasAction && elements.hasMoreElements())
				{
					Debt x2yDebt = (Debt)elements.nextElement();
					if (pertainToGroup(x2yDebt.whom) != null)
					{
						log.appendText("removing debt " + x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.red, false);
						x.removeDebt(x2yDebt);
						wasAction = true;
					}
				}
			}
		}
	}
	
	private boolean doBijectiveReductions(Debtor x, Debt x2yDebt, Debtor y, Debt y2zDebt)
	{
		boolean wasAction = false;
		
		log.appendText("\n----- Bijective Reductions ------", Color.blue, true);

		if (/*y2zDebt != null && */y2zDebt.whom.equals(x.who))
		{
			log.appendText("reducing ----- ", Color.black, false);
			log.appendText(x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.gray, false);
			log.appendText(y.who + "-<" + y2zDebt.what + ">->" + y2zDebt.whom, Color.gray, false);
			log.appendText("--into", Color.black, false);

			if (x2yDebt.what >= y2zDebt.what)
			{
				/*
				 *  x -(a)-> y / y -(b)-> x / a >= b
				 *  
				 * 		:=> x -(a-b)-> y 
				 * 		:=> y -(0)-> x
				 *
				*/     
				x2yDebt.what -= y2zDebt.what;
				y.removeDebt(y2zDebt);

				log.appendText(x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.black, false);
				log.appendText(y.who + "-<0.0>->" + x.who, Color.red, false);
			}
			else
			{
				/*
				 * 
				 *  x -(a)-> y / y -(b)-> x / a < b
				 *  
				 * 		:=> x -(0)-> y 
				 * 		:=> y -(b-a)-> x
				 * 
				*/
				y2zDebt.what -= x2yDebt.what;
				x.removeDebt(x2yDebt);

				log.appendText(y.who + "-<" + y2zDebt.what + ">->" + y2zDebt.whom, Color.black, false);
				log.appendText(x.who + "-<0.0>->" + y.who, Color.red, false);
			}	
			
			wasAction = true;
		}
	
		return wasAction;
	}
	
	private boolean doTransitiveReductions(Debtor x, Debt x2yDebt, Debtor y, Debt y2zDebt, Debtor z, Debt x2zDebt)
	{
		boolean wasAction = false;
		
		log.appendText("\n----- Transitive Reductions ------", Color.blue, true);


		// x -> y -> z && x -> z
		if (x2zDebt != null && !x2zDebt.whom.equals(x.who))
		{
			log.appendText("reducing ----- ", Color.black, false);
			log.appendText(x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.gray, false);
			log.appendText(y.who + "-<" + y2zDebt.what + ">->" + y2zDebt.whom, Color.gray, false);
			log.appendText(x.who + "-<" + x2zDebt.what + ">->" + x2zDebt.whom, Color.gray, false);
			log.appendText("--into", Color.black, false);

			if (x2yDebt.what <= y2zDebt.what)
			{
				/*
				 *  x -(a)-> y / y -(b)-> z / x -(c)-> z / a <= b
				 * 
				 * 		:=> y -(b-a)-> z
				 * 		:=> x -(0)-> y
				 * 		:=> x -(c+a)-> z
				 *
				*/
				x2zDebt.what += x2yDebt.what;
				y2zDebt.what -= x2yDebt.what;
				x.removeDebt(x2yDebt);

				log.appendText(y.who + "-<" + y2zDebt.what + ">->" + y2zDebt.whom, Color.black, false);
				log.appendText(x.who + "-<" + x2zDebt.what + ">->" + x2zDebt.whom, Color.black, false);
				log.appendText(x.who + "-<0.0>->" + y.who, Color.red, false);
			}
			else
			{
				/* 
				 * x -(a)-> y / y -(b)-> z / x -(c)-> z / a > b
				 * 
				 * 		:=> y -(0)-> z
				 * 		:=> x -(a-b) -> y
				 * 		:=> x -(c+b) -> z
				 */
				x2zDebt.what += y2zDebt.what;
				x2yDebt.what -= y2zDebt.what;
				y.removeDebt(y2zDebt);

				log.appendText(x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.black, false);
				log.appendText(x.who + "-<" + x2zDebt.what + ">->" + x2zDebt.whom, Color.black, false);
				log.appendText(y.who + "-<0.0>->" + z.who, Color.red, false);
			}
			
			wasAction = true;
		}
		else if (x2yDebt.what >= y2zDebt.what)
		{
			log.appendText("reducing ----- ", Color.black, false);
			log.appendText(x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.gray, false);
			log.appendText(y.who + "-<" + y2zDebt.what + ">->" + y2zDebt.whom, Color.gray, false);
			log.appendText("--into", Color.black, false);

			/*
			 *     
			 *  x -(a)-> y / y -(b)-> z / a >= b
			 *  
			 * 		:=> x -(a-b)-> y 
			 * 		:=> x -(b)-> z
			 * 		:=> y -(0)-> z
			 *
 			 */
			x2yDebt.what -= y2zDebt.what;
			if (x2zDebt != null)
				x2zDebt.what += y2zDebt.what;
			else
				x2zDebt = x.addDebt(y2zDebt.what, z.who, z.isPerson);
			y.removeDebt(y2zDebt);
			
			log.appendText(x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.black, false);
			log.appendText(x.who + "-<" + x2zDebt.what + ">->" + x2zDebt.whom, Color.black, false);
			log.appendText(y.who + "-<0.0>->" + z.who, Color.red, false);

			wasAction = true;
		}

		return wasAction;
	}
	
	private boolean doCyclicReductions(Debtor x, Debt x2yDebt, Debtor y, Debt y2zDebt, Debtor z, Debt x2zDebt)
	{
		boolean wasAction = false;
		
		log.appendText("\n----- Cyclic Reductions ------", Color.blue, true);

		Debt z2xDebt = z.findDebt(x.who);
		if (z2xDebt != null && !z2xDebt.whom.equals(z.who))
		{
			log.appendText("reducing ----- ", Color.black, false);
			log.appendText(x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.gray, false);
			log.appendText(y.who + "-<" + y2zDebt.what + ">->" + y2zDebt.whom, Color.gray, false);
			log.appendText(z.who + "-<" + z2xDebt.what + ">->" + z2xDebt.whom, Color.gray, false);
			log.appendText("--into", Color.black, false);

			if (x2yDebt.what >= y2zDebt.what) // a >= b
			{
				if (z2xDebt.what >= y2zDebt.what) //  c >= b
				{
					/*
					 *  x -(a)-> y / y -(b)-> z / z -(c)-> x / a >= b, c >= b
					 *
					 *		:=> x -(a-b)-> y
					 * 		:=> y -(0)-> z
					 *      :=> z -(c-b)-> x
					 *   
					 */
					x2yDebt.what -= y2zDebt.what;
					z2xDebt.what -= y2zDebt.what;
					y.removeDebt(y2zDebt);

					log.appendText(x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.black, false);
					log.appendText(z.who + "-<" + z2xDebt.what + ">->" + z2xDebt.whom, Color.black, false);
					log.appendText(y.who + "-<0.0>->" + z.who, Color.red, false);
				}
				else // c < b
				{
					/*
					 *  x -(a)-> y / y -(b)-> z / z -(c)-> x / a >= b, c < b
					 *
					 *		:=> x -(a-b)-> y
					 * 		:=> y -(0)-> z
					 *      :=> z -(0)-> x
					 *      :=> x -(b-c)-> z
					 */
					x2yDebt.what -= y2zDebt.what;
					x2zDebt = x.findDebt(z.who);
					if (x2zDebt != null) 
						x2zDebt.what += y2zDebt.what - z2xDebt.what;
					else
						x2zDebt = x.addDebt(y2zDebt.what - z2xDebt.what, z.who, true);
					y.removeDebt(y2zDebt);
					z.removeDebt(z2xDebt);

					log.appendText(x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.black, false);
					log.appendText(x.who + "-<" + x2zDebt.what + ">->" + x2zDebt.whom, Color.black, false);
					log.appendText(y.who + "-<0.0>->" + z.who, Color.red, false);
					log.appendText(z.who + "-<0.0>->" + x.who, Color.red, false);
				}
				
				wasAction = true;
			}
			else // a < b
			{
				if (z2xDebt.what >= y2zDebt.what) // c >= b (a < b <= c)
				{
					/*
					 *  x -(a)-> y / y -(b)-> z / z -(c)-> x / a < b, c >= b
					 *
					 *		:=> x -(0)-> y
					 * 		:=> y -(b-a)-> z
					 *      :=> z -(c-a)-> x
					 *   
					 */
					z2xDebt.what -= x2yDebt.what;
					y2zDebt.what -= x2yDebt.what;
					x.removeDebt(x2yDebt);

					log.appendText(y.who + "-<" + y2zDebt.what + ">->" + y2zDebt.whom, Color.black, false);
					log.appendText(z.who + "-<" + z2xDebt.what + ">->" + z2xDebt.whom, Color.black, false);
					log.appendText(x.who + "-<0.0>->" + y.who, Color.red, false);
				}
				else // c < b
				{	
					if (z2xDebt.what <= x2yDebt.what) // c <= a
					{
						/*
						 *  x -(a)-> y / y -(b)-> z / z -(c)-> x / a < b, c < b, c <= a
						 *
						 *		:=> x -(a-c)-> y
						 * 		:=> y -(b-c)-> z
						 *      :=> z -(0)-> x
						 */
						x2yDebt.what -= z2xDebt.what;
						y2zDebt.what -= z2xDebt.what;
						z.removeDebt(z2xDebt);
	
						log.appendText(x.who + "-<" + x2yDebt.what + ">->" + x2yDebt.whom, Color.black, false);
						log.appendText(y.who + "-<" + y2zDebt.what + ">->" + y2zDebt.whom, Color.black, false);
						log.appendText(z.who + "-<0.0>->" + x.who, Color.red, false);
					}
					else // c > a
					{
						/*
						 *  x -(a)-> y / y -(b)-> z / z -(c)-> x / a < b, c < b, c > a
						 *
						 *		:=> x -(0)-> y
						 *      :=> y -(b-a)-> z
						 * 		:=> z -(c-a)-> x
						 */
						y2zDebt.what -= x2yDebt.what;
						z2xDebt.what -= x2yDebt.what;
						x.removeDebt(x2yDebt);
	
						log.appendText(y.who + "-<" + y2zDebt.what + ">->" + y2zDebt.whom, Color.black, false);
						log.appendText(z.who + "-<" + z2xDebt.what + ">->" + z2xDebt.whom, Color.black, false);
						log.appendText(x.who + "-<0.0>->" + y.who, Color.red, false);
					}
				}
				
				wasAction = true;
			}
		}
		
		return wasAction;
	}
	private void doReductions()
	{
		// iterate on all wow data and for each x try to do a reduction
		boolean wasAction = false;

		log.appendText("\n----- Processing with graph reduction ------", Color.blue, true);

		Iterator i = iterator();
		for(;;)
		{
			if (wasAction)
			{
				i = iterator();
				wasAction = false;
			}

			if (!i.hasNext())
				break;
			
			// get a valid x.
			Debtor x = (Debtor)i.next();
				
			// got x, look for y
			Debt   x2yDebt = null;
			Debtor y = null;
			Enumeration xElements = x.getDebts();
			while (!wasAction && xElements.hasMoreElements())
			{
				x2yDebt = (Debt)xElements.nextElement();
				if ((y = findDebtor(x2yDebt.whom)) == null)
					y = new Debtor(x2yDebt.whom);

				// got x and y, look for possible z.
				Debtor z = null;
				Debt   y2zDebt = null;
				Enumeration yElements = y.getDebts();
				while (!wasAction && yElements.hasMoreElements())
				{
					y2zDebt = (Debt)yElements.nextElement();
					if ((z = findDebtor(y2zDebt.whom)) == null)
						z = new Debtor(y2zDebt.whom);

					log.appendText("\ndoReductions(" + x.who + ", " + y.who + ", " + z.who + ")", Color.magenta, true);

					// bijection reduction... x <-> y
					if (wasAction = doBijectiveReductions(x, x2yDebt, y, y2zDebt))
						continue;
					
					Debt x2zDebt = x.findDebt(z.who);
		
					// transitive reduction x -> y -> z
					if ((wasAction = doTransitiveReductions(x, x2yDebt, y, y2zDebt, z, x2zDebt)))
						continue;
					
					// cyclic reduction
					// x -> y -> z && z -> x
					if ((wasAction = doCyclicReductions(x, x2yDebt, y, y2zDebt, z, x2zDebt)))
						continue;
				}
			}
		}
	}
	
	// full reduction of the graph
	public void solve()
	{
		log.clear();
		
		convertUsagesIntoDebts(); 	// first convert all usages into debts.
		removeUsagesAndPayments();	// remove original usages and payments from graph

		// first pass on people
		doReductions();				// reduce the graph

		// second pass on groups
		generateGroupDebts();		// generate the groups and the associated debts and debtors
		doReductions();				// reduce the graph
		removeGroupedDebts();		// remove debts inside groups

		sanitize(); 				// remove invalid debts/debtors
	}
}
