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
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

/*
 * Created on Feb 16, 2005
 *
 * This module handles the wow data.
 *   
 */

/**
 * @author gilles.fabre
 *
 * @class WowTable extends TableModel by storing a two dimensional Vector 
 * representation of the current wow problem. A WowTable instance is used to feed
 * the WowMatrix instance of the application.
 * 
 */
public final class WowTable implements TableModel 
{
	static final String COLUMN_NAMES[] = {Messages.getString("WowTable.0"), Messages.getString("WowTable.1"), Messages.getString("WowTable.2"), Messages.getString("WowTable.3"), Messages.getString("WowTable.4")}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	public final static int WHO_COLUMN = 0,
					 		DOES_COLUMN = 1,
							WHAT_COLUMN = 2,
							TO_FOR_COLUMN = 3,
							WHEN_COLUMN = 4,
							NUM_COLUMNS = 5;

	private Vector 	rows;
	
	WowTable() {rows = new Vector();}
	
	public int getColumnCount() 
	{
		return NUM_COLUMNS;
	}

	public int getRowCount() 
	{
		return rows.size();
	}

	public boolean isCellEditable(int arg0, int arg1) 
	{
		return false;
	}

	public Class<?> getColumnClass(int arg0) 
	{
		switch (arg0)
		{
			case WHO_COLUMN:
			case DOES_COLUMN:
			case TO_FOR_COLUMN:
			case WHEN_COLUMN:
				return new String().getClass();

			case WHAT_COLUMN:
				return new Float(0).getClass();
		}
			
		return null;
	}

	public Object getValueAt(int arg0, int arg1) 
	{
		if (getRowCount() > arg0 &&
			getColumnCount() > arg1)	
			return ((Vector)rows.elementAt(arg0)).elementAt(arg1);
		
		return null;
	}

	public String getColumnName(int arg0) 
	{
		if (arg0 >= COLUMN_NAMES.length)
			return null;
		
		return COLUMN_NAMES[arg0];
	}

	public void setValueAt(Object arg0, int arg1, int arg2) 
	{
		if (arg2 >= NUM_COLUMNS)
			return;

		if (arg0.getClass() != getColumnClass(arg2))
			return;

		// add a new row ?
		if (arg1 >= getRowCount())
		{
			Vector column = new Vector();
			
			column.add(new String()); 
			column.add(new String()); 
			column.add(new Float(0));
			column.add(new String()); 
			column.add(new String());
			rows.add(column);
		}

		((Vector)rows.elementAt(arg1)).setElementAt(arg0, arg2);
	}
	
	public void clear()
	{
		rows.clear();
	}
	
	public void deleteRow(int rowNum) 
	{
		if (getRowCount() != 0 && rowNum < getRowCount())
			rows.remove(rowNum);
	} 

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#addTableModelListener(javax.swing.event.TableModelListener)
	 */
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#removeTableModelListener(javax.swing.event.TableModelListener)
	 */
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString()
	{
		String string = new String("");
		
		for (Enumeration e = rows.elements(); e.hasMoreElements() ;) 
		{
	         string += e.nextElement().toString();
	         string += "\n"; 
		}
		
		return string;
	}
	
	public void fromString(String str)
	{
		clear(); 

		Reader r = new StringReader(str);
		StreamTokenizer st = new StreamTokenizer(r);
		st.eolIsSignificant(true); // vector ends with \n
		st.ordinaryChar(',');
		st.ordinaryChar('[');
		st.ordinaryChar(']');
		st.ordinaryChar(':');
		st.ordinaryChar('/');
		st.parseNumbers();
       
		try 
		{
       		int 	column = WHO_COLUMN,
					row = 0;
       		String	dateStr = new String();
       		
       		// iterate on file content...
       		while (st.nextToken() != StreamTokenizer.TT_EOF)
       		{
   				// possibly new row after this token 
   				switch (st.ttype)
				{
   					case ',':
   						// vector items separator
       					++column;
       					continue;
	       				
   					case '[':
	       				// start of vector, just skip.
       					continue;
	       				
   					case StreamTokenizer.TT_EOL:
						++row;
	   					column = 0;
	   					continue;
	   					
   					case ']':
   						DateFormat 	dateFmt = new SimpleDateFormat();
   						Date		date = new Date();

   						dateStr = dateStr.substring(0, dateStr.length() - 1);
   						date = dateFmt.parse(dateStr);
   						setValueAt(dateStr, row, column);
   						dateStr = "";
						break;
   						
   					case ':':
   						// date separators
   						dateStr = dateStr.substring(0, dateStr.length() - 1);
   						dateStr += ":";
   						break;

   					case '/':
   						// date separators
   						dateStr = dateStr.substring(0, dateStr.length() - 1);
   						dateStr += "/";
   						break;
   						
       				case StreamTokenizer.TT_NUMBER:
       					// need a string format for the date
       					st.sval = new Float(st.nval).toString();
       					if (st.sval.endsWith(".0"))
       						st.sval = st.sval.substring(0, st.sval.length() - 2);
						
       				case StreamTokenizer.TT_WORD:
	       				switch(column)
						{
	       					case WHO_COLUMN:
	       					case DOES_COLUMN:
	       					case TO_FOR_COLUMN:
	       						setValueAt(new String(st.sval), row, column);
	       						break;
	       						
	       					case WHAT_COLUMN:
	       						setValueAt(new Float(st.nval), row, column);
	       						break;
	
	       					case WHEN_COLUMN:
	       						dateStr += st.sval + " ";
	       						break;
						}
	       				break;
       			}
       		}
		} 
       
		catch (IOException e) 
		{
			WowAlert alert = new WowAlert(WowApplication.getWindow(), e.getMessage());
			alert.setVisible(true);
	   	} 
       	
		catch (ParseException e) 
	   	{
			WowAlert alert = new WowAlert(WowApplication.getWindow(), e.getMessage());
			alert.setVisible(true);
	   	}
	}
}

