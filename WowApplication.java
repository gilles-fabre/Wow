/*
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
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.lang.System;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author gilles.fabre
 *
 * This application solves the "Who owes Whom" problem which you'll need to solve 
 * everytime you go on holidays with friends ;-)
 * 
 */

public final class WowApplication 
{
	// the main application window
	static WowWindow 	wowWnd;
	static final String	WOW_FILE_EXTENSION = ".wow";

	// this method initializes the look and feel to default.
	private void initLookAndFeel() 
	{
        String lookAndFeel = null;

       	lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        try 
        {
        	UIManager.setLookAndFeel(lookAndFeel);
        } 
        catch (ClassNotFoundException e) 
        {
            System.err.println(Messages.getString("WowApplication.0") //$NON-NLS-1$
                               + lookAndFeel);
            System.err.println(Messages.getString("WowApplication.1")); //$NON-NLS-1$
            System.err.println(Messages.getString("WowApplication.2")); //$NON-NLS-1$
        } 
        catch (UnsupportedLookAndFeelException e) 
        {
            System.err.println(Messages.getString("WowApplication.3") //$NON-NLS-1$
                               + lookAndFeel
                               + Messages.getString("WowApplication.4")); //$NON-NLS-1$
            System.err.println(Messages.getString("WowApplication.5")); //$NON-NLS-1$
        } 
        catch (Exception e) 
        {
            System.err.println(Messages.getString("WowApplication.6") //$NON-NLS-1$
                               + lookAndFeel
                               + Messages.getString("WowApplication.7")); //$NON-NLS-1$
            System.err.println(Messages.getString("WowApplication.8")); //$NON-NLS-1$
            e.printStackTrace();
        }
    }
    
	// the application constructor: creates the main window.
	WowApplication() 
	{
        initLookAndFeel();
		wowWnd = new WowWindow();
	}
	
	// the application run method: invoke this to run Wow
	public void run() {
		wowWnd.pack();
		wowWnd.setVisible(true);
	}
	
	/**
	 * @class WowWindow
	 * 
	 * this class extends the standard JFrame class to add all the Wow 
	 * functionnalities. It contains a toolbar including command buttons
	 * and a tab pane including a matrix and a graph showing the wow problem. 
	 * A log tab shows the resolution process log. 
	 * 
	 */
	class WowWindow extends JFrame 
	{
		WowWindow		wowWindow;
		JTabbedPane 	tabs = new JTabbedPane();
		WowMatrix		matrix; // = new WowMatrix();
		JButton			compute = new JButton(Messages.getString("WowApplication.9")), //$NON-NLS-1$
						add = new JButton(Messages.getString("WowApplication.10")), //$NON-NLS-1$
						delete = new JButton(Messages.getString("WowApplication.11")), //$NON-NLS-1$
						clear = new JButton(Messages.getString("WowApplication.21")), //$NON-NLS-1$
						save = new JButton(Messages.getString("WowApplication.22")), //$NON-NLS-1$
						load = new JButton(Messages.getString("WowApplication.23")); //$NON-NLS-1$
		JToolBar		toolbar = new JToolBar(JToolBar.HORIZONTAL);
		WowTable 		table = new WowTable();
		WowLog			log = new WowLog();
		WowGraph		graph = new WowGraph(log);
		WowGraphView 	graphView = new WowGraphView(graph);
		
		/**
		 * @class AddAction
		 * 
		 * this class extends the standard ActionListener to add a new entry in the . 
		 * wow table.
		 */
		class AddAction implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				int rowIndex = table.getRowCount();
				
				WowEntry entry = new WowEntry(wowWindow);
				
				entry.setVisible(true);

				if (entry.wasValidated())
				{
					DateFormat 	dateFmt = new SimpleDateFormat();

					Vector newEntry = entry.getEntry();

					table.setValueAt(newEntry.elementAt(WowTable.WHO_COLUMN), rowIndex, WowTable.WHO_COLUMN);
					table.setValueAt(newEntry.elementAt(WowTable.DOES_COLUMN), rowIndex, WowTable.DOES_COLUMN);
					table.setValueAt(newEntry.elementAt(WowTable.WHAT_COLUMN), rowIndex, WowTable.WHAT_COLUMN);
					table.setValueAt(newEntry.elementAt(WowTable.TO_FOR_COLUMN), rowIndex, WowTable.TO_FOR_COLUMN);
					table.setValueAt(dateFmt.format(new Date()), rowIndex, WowTable.WHEN_COLUMN);

					graph.updateData(table);
					graph.updateGraphView();
					matrix.invalidate();
					matrix.updateUI();
					graphView.updateUI();
				}
			}
		}

		/**
		 * @class DeleteAction
		 * 
		 * this class extends the standard ActionListener to delete the currently selected entry from the 
		 * wow table.
		 */
		class DeleteAction implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				int rowIndex = matrix.getSelectedRow();
				if (rowIndex == -1)
					return;
				
				table.deleteRow(rowIndex);
				graph.updateData(table);
				graph.updateGraphView();
				matrix.invalidate();
				matrix.updateUI();
				graphView.updateUI();
			}
		}

		/**
		 * @class ComputeAction
		 * 
		 * this class extends the standard ActionListener to reduce the wow table.
		 */
		class ComputeAction implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				graph.solve();
				graph.updateTable(table);
				graph.updateGraphView();
				matrix.invalidate();
				matrix.updateUI();
				graphView.updateUI();
			}
		}

		class WowFilter extends FileFilter
		{
			// Whether the given file is accepted by this filter.
			public boolean accept(File f)
			{
				 return f.getName().endsWith(".wow") || //$NON-NLS-1$
				 		f.isDirectory();
			}

			// The description of this filter. For example: "JPG and GIF Images"
			public String getDescription()
			{
				return new String(Messages.getString("WowApplication.14")); //$NON-NLS-1$
			}
		}

		/**
		 * @class SaveAction
		 * 
		 * this class extends the standard ActionListener to save the wow table to the selected file.
		 */
		class SaveAction implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser();
				chooser.setFileFilter(new WowFilter());
			    if(chooser.showSaveDialog(wowWindow) == JFileChooser.APPROVE_OPTION) 
			    {
			    	String filename = chooser.getSelectedFile().getAbsolutePath();
		    		   
	    		    if (!filename.endsWith(WOW_FILE_EXTENSION))
	    		    	filename += WOW_FILE_EXTENSION;

	    			File file = new File(filename);
			    	if (file.exists())
			    	{
						WowAlert alert = new WowAlert(wowWindow, Messages.getString("WowApplication.13") + file.getName() + "?", WowAlert.CONFIRMATION_ALERT); //$NON-NLS-1$ //$NON-NLS-2$
						alert.setVisible(true);
						if (!alert.wasValidated())
							return;

				    	if (!file.canWrite())
				    	{
							alert = new WowAlert(wowWindow, file.getName() + Messages.getString("WowApplication.12")); //$NON-NLS-1$
							alert.setVisible(true);
							return;
				    	}
			    	}
		    		try 
					{
						FileOutputStream outFile = new FileOutputStream(file);
						try 
						{
							outFile.write(table.toString().getBytes());
						} 
						catch (IOException ex2) 
						{
							WowAlert alert = new WowAlert(wowWindow, ex2.getMessage());
							alert.setVisible(true);
						}
						
						outFile.close(); 
					} 
		    		catch (FileNotFoundException ex1) 
					{
						WowAlert alert = new WowAlert(wowWindow, ex1.getMessage());
						alert.setVisible(true);
					} 
		    		catch (IOException ex3) 
					{
						WowAlert alert = new WowAlert(wowWindow, ex3.getMessage());
						alert.setVisible(true);
					}
			    }
			}
		}

		/**
		 * @class clearAction
		 * 
		 * this class extends the standard ActionListener to clear the wow table.
		 */
		class ClearAction implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				table.clear();
				graph.updateData(table);
				graph.updateGraphView();
				matrix.invalidate();
				matrix.updateUI();
				graphView.updateUI();
			}
		}

		/**
		 * @class LoadAction
		 * 
		 * this class extends the standard ActionListener to load into the wow table the content of the selected file.
		 */
		class LoadAction implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser();
				chooser.setFileFilter(new WowFilter());
			    if(chooser.showOpenDialog(wowWindow) == JFileChooser.APPROVE_OPTION) 
			    {
			    	File file = chooser.getSelectedFile();
			    	if (!file.canRead() || !file.exists())
			    	{
						WowAlert alert = new WowAlert(wowWindow, file.getName() + Messages.getString("WowApplication.15"));  //$NON-NLS-1$
						alert.setVisible(true);
						return;
			    	}

			    	try 
					{
						FileInputStream inFile = new FileInputStream(file);
						try 
						{
							int	 len = inFile.available();
							byte b[] = new byte[len + 1];
							
							inFile.read(b, 0, len);
							table.fromString(new String(b));
							graph.updateData(table);
							graph.updateGraphView();
							matrix.invalidate();
							matrix.updateUI();
							graphView.updateUI();
						} 
						catch (IOException ex2) 
						{
							WowAlert alert = new WowAlert(wowWindow, ex2.getMessage());
							alert.setVisible(true);
						}
						
						inFile.close(); 
					} 
		    		catch (FileNotFoundException ex1) 
					{
						WowAlert alert = new WowAlert(wowWindow, ex1.getMessage());
						alert.setVisible(true);
					} 
		    		catch (IOException ex3) 
					{
						WowAlert alert = new WowAlert(wowWindow, ex3.getMessage());
						alert.setVisible(true);
					}
			    }
			}
		}

		public WowWindow() 
		{
			// create the window
			super(Messages.getString("WowApplication.17"));  //$NON-NLS-1$
			frameInit();
			
			// create the matrix
			matrix = new WowMatrix(table);

			// set the close method
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	        // sets the layout
			BorderLayout layout = new BorderLayout();
			getContentPane().setLayout(layout);

			// add the buttons in the toolbar
			toolbar.add(clear);
			toolbar.add(compute);
			toolbar.add(add);
			toolbar.add(delete);
			toolbar.add(load);
			toolbar.add(save);
			
			// add the toolbar and the tab pane on the content pane
			getContentPane().add(toolbar, BorderLayout.NORTH);
			getContentPane().add(tabs, BorderLayout.CENTER);
			tabs.setBorder(BorderFactory.createEmptyBorder());

			// add the matrix and the graphView in the tab pane
			String title = Messages.getString("WowApplication.18"); //$NON-NLS-1$
			matrix.getPane().setName(title);
			title = Messages.getString("WowApplication.19"); //$NON-NLS-1$
			graphView.setName(title);
			title = Messages.getString("WowApplication.20"); //$NON-NLS-1$			
			log.getPane().setName(title);
			tabs.addTab(matrix.getPane().getName(), matrix.getPane());
			tabs.addTab(graphView.getName(), graphView);
			tabs.addTab(log.getPane().getName(), log);
			
			doLayout();
			
			// set listeners for the buttons
			clear.addActionListener(new ClearAction());
			add.addActionListener(new AddAction());
			delete.addActionListener(new DeleteAction());
			compute.addActionListener(new ComputeAction());
			save.addActionListener(new SaveAction());
			load.addActionListener(new LoadAction());
			
			wowWindow = this;
		} 
	}
	
	/**
	 * Wow Application entry point
	 * @param args
	 * @return nothing
	 * @exception no exception thrown
	 */
	public static void main(String[] args) 
	{
//		Properties p = System.getProperties();
//		p.list(System.out);
		
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
				WowApplication wowApp = new WowApplication();
                wowApp.run();
            }
        });
	}

	public static WowGraph getGraph() 
	{
		return wowWnd.graph;
	}

	public static WowWindow getWindow() 
	{
		return wowWnd;
	}
}

