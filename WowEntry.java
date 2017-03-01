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
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Vector;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/*
 * Created on Feb 16, 2005
 *
 * This is the wow entry edition module.
 * 
 */

/**
 * @author gilles.fabre
 *
 * @class WowEntry
 * 
 * This class extends JDialog to edit a new entry field. It must be instanciated by 
 * calling it constructor with the parent frame object (to create an application 
 * model dialog). if this.wasValidated(), the user has entered a valid new entry 
 * in the wow entry dialog which vectorized value can be retrieved by calling 
 * getEntry.
 * 
 */
public final class WowEntry extends JDialog 
{
	WowEntry dialog;
	
	private	boolean wasValidated;
	
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private DebtorField WhoField = null;
	private JLabel jLabel1 = null;
	private JComboBox DoesCombo = null;
	private JLabel jLabel2 = null;
	private JTextField WhatField = null;
	private JLabel jLabel3 = null;
	private DebtorField WhomField = null;
	private JButton OkButton = null;
	private JButton CancelButton = null;
	
	class DebtorField extends JTextField 
	{
	     protected Document createDefaultModel() 
	     {
	         return new DebtorDocument();
	     }
	 
	     class DebtorDocument extends PlainDocument 
	     {
	    	 Boolean reenter  = false;
	    	 
	    	 public void insertString(int offs, String str, AttributeSet a) throws BadLocationException 
	    	 {
    			 super.insertString(offs, str, a);
    			 
    			 if (reenter == true) // yuk! super.replace invokes insertString...
    				 return;
    			 
				 // try to find an existing debtor with the current prefix
    			 int len = super.getLength();
				 String content = super.getText(0, len);
	    		 WowGraph.Debtor debtor = WowApplication.getGraph().findDebtorStartingWith(content);
	    		 if (debtor != null) 
	    		 {
	    			 String who = debtor.getWho();
	    			 reenter = true;
   					 super.replace(0, len, who, a);
	   				 select(content.length(), who.length());
	    			 reenter = false;
   				 } 
	        }
		}
	}
	
	class DebtorVerifier extends InputVerifier 
	{
        public boolean verify(JComponent input) 
        {
	       JTextField tf = (JTextField)input;
	       String prefix = tf.getText();
	       Reader r = new StringReader(prefix);
	       StreamTokenizer st = new StreamTokenizer(r);
	       st.wordChars('a', 'z');
	       st.wordChars('A', 'Z');
	       try 
		   {
	       		st.nextToken();
	       } 
	       catch (IOException e) 
		   {
				WowAlert alert = new WowAlert(dialog, Messages.getString("WowEntry.4"), WowAlert.ERROR_ALERT); //$NON-NLS-1$
				alert.setVisible(true);
	       		return false;
		   }

	       return st.ttype == StreamTokenizer.TT_WORD;
        }
    }

	class FloatVerifier extends InputVerifier 
	{
        public boolean verify(JComponent input) 
        {
	       JTextField tf = (JTextField)input;
	       if (!tf.isEnabled())
	       		return true;
	       
	       if (tf.getText().length() == 0)
       			return false;
       		
	       try 
		   {
	       		Float.parseFloat(tf.getText());
	       }
	       catch (NumberFormatException e)
		   {
				WowAlert alert = new WowAlert(dialog, Messages.getString("WowEntry.5"), WowAlert.ERROR_ALERT); //$NON-NLS-1$
				alert.setVisible(true);
	       		return false;
		   }
	       
	       return true;
        }
    }

	class OkAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// #### check that an existing individual or group wasn't recreated
			if (getWhoField().getText().length() != 0 &&
				getWhoField().getInputVerifier().verify(getWhoField()) && 
				getWhatField().getInputVerifier().verify(getWhatField()) && 
				getWhomField().getText().length() != 0 &&
				getWhomField().getInputVerifier().verify(getWhomField())) 
			{
				wasValidated = true;
				dialog.dispose();
			}
		}
	}
	
	class CancelAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dialog.dispose();
		}
	}

	/**
	 * This method builds an application modal wow entry edition dialog  
	 * 
	 */
	public WowEntry(Frame owner) 
	{
		super(owner);
		setLocationRelativeTo(owner);
		initialize();
		dialog = this;

		// set listeners for the buttons
		getOkButton().addActionListener(new OkAction());
		getCancelButton().addActionListener(new CancelAction());
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	class DoesComboListener implements ActionListener, ItemListener
	{
		private void checkContent()
		{
			// #### check that if a group was entered in the 'who' field, 'use' was the selected action
			Boolean hide = getDoesCombo().getSelectedItem().toString().equals(Messages.getString("WowEntry.17"));
			getWhatField().setEnabled(!hide);
			getWhatField().setVisible(!hide);
		}
		public void actionPerformed(ActionEvent e)
		{
			checkContent();
		}

		public void itemStateChanged(ItemEvent arg0) 
		{
			checkContent();
		}
	}
	
	private void initialize() 
	{
        this.setResizable(false);
        this.setModal(true);
        this.setTitle(Messages.getString("WowEntry.0")); //$NON-NLS-1$
        this.setContentPane(getJPanel());
        this.setSize(308, 220);
		getDoesCombo().addActionListener(new DoesComboListener());
		getDoesCombo().addItemListener(new DoesComboListener());
	}
	
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() 
	{
		if (jPanel == null) 
		{
			jLabel3 = new JLabel();
			jLabel2 = new JLabel();
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jLabel.setBounds(14, 10, 59, 26);
			jLabel.setText(Messages.getString("WowEntry.1")); //$NON-NLS-1$
			jLabel1.setBounds(14, 46, 59, 24);
			jLabel1.setText(Messages.getString("WowEntry.2")); //$NON-NLS-1$
			jLabel2.setBounds(14, 80, 59, 24);
			jLabel2.setText(Messages.getString("WowEntry.3")); //$NON-NLS-1$
			jLabel3.setText("To/For: "); //$NON-NLS-1$
			jLabel3.setSize(59, 27);
			jLabel3.setLocation(14, 114);
			jPanel.add(jLabel, null);
			jPanel.add(getWhoField(), null);
			jPanel.add(jLabel3, null);
			jPanel.add(getWhomField(), null);
			jPanel.add(getOkButton(), null);
			jPanel.add(getCancelButton(), null);
			jPanel.add(getCancelButton(), null);
			jPanel.add(jLabel1, null);
			jPanel.add(getDoesCombo(), null);
			jPanel.add(jLabel2, null);
			jPanel.add(getWhatField(), null);
		}
		return jPanel;
	}
	
	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private DebtorField getWhoField() 
	{
		if (WhoField == null) 
		{
			WhoField = new DebtorField();
			WhoField.setBounds(76, 11, 207, 26);
			WhoField.setToolTipText("*WHO* pays/owes/uses/.."); //$NON-NLS-1$
			WhoField.setInputVerifier(new DebtorVerifier());
		}
		return WhoField;
	}
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getDoesCombo() 
	{
		if (DoesCombo == null) 
		{
			DoesCombo = new JComboBox();
			DoesCombo.setBounds(76, 47, 112, 24);
			DoesCombo.addItem(Messages.getString("WowEntry.6")); //$NON-NLS-1$
			DoesCombo.addItem(Messages.getString("WowEntry.7")); //$NON-NLS-1$
			DoesCombo.addItem(Messages.getString("WowEntry.8")); //$NON-NLS-1$
			DoesCombo.addItem(Messages.getString("WowEntry.9")); //$NON-NLS-1$
			DoesCombo.addItem(Messages.getString("WowEntry.10")); //$NON-NLS-1$
			DoesCombo.addItem(Messages.getString("WowEntry.16")); //$NON-NLS-1$
			DoesCombo.addItem(Messages.getString("WowEntry.17")); //$NON-NLS-1$
			DoesCombo.setMaximumRowCount(4);
			DoesCombo.setEditable(false);
			DoesCombo.setToolTipText("who does *USE/OWE/PAY/..*"); //$NON-NLS-1$
		}
		return DoesCombo;
	}
	
	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getWhatField() 
	{
		if (WhatField == null) 
		{
			WhatField = new JTextField();
			WhatField.setBounds(76, 81, 207, 24);
			WhatField.setToolTipText("who does pay *WHAT* ..."); //$NON-NLS-1$
			WhatField.setInputVerifier(new FloatVerifier());
		}
		return WhatField;
	}
	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private DebtorField getWhomField() 
	{
		if (WhomField == null) 
		{
			WhomField = new DebtorField();
			WhomField.setBounds(76, 115, 207, 27);
			WhomField.setToolTipText("who does pay/owe/use what *FOR/TO WHOM/WHAT/..*"); //$NON-NLS-1$
			WhomField.setInputVerifier(new DebtorVerifier());
		}
		return WhomField;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getOkButton() 
	{
		if (OkButton == null) 
		{
			OkButton = new JButton();
			OkButton.setBounds(7, 156, 80, 30);
			OkButton.setText(Messages.getString("WowEntry.14")); //$NON-NLS-1$
		}
		return OkButton;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getCancelButton() 
	{
		if (CancelButton == null) 
		{
			CancelButton = new JButton();
			CancelButton.setText(Messages.getString("WowEntry.15")); //$NON-NLS-1$
			CancelButton.setBounds(91, 156, 80, 30);
		}
		return CancelButton;
	}

	/**
	 * This method returns (the currently edited wow entry is valid and 
	 * the user has selected the 'ok' button.	
	 * 	
	 * @return boolean
	 */    
	public boolean wasValidated() {return wasValidated;}

	/**
	 * This method returns a valid vectorized new wow entry	
	 * 	
	 * @return java.util.Vector
	 */    
	public Vector getEntry()
	{
		Vector entry = new Vector();
		
		entry.add(new String(getWhoField().getText()));
		entry.add(new String(getDoesCombo().getSelectedItem().toString()));
		if (getDoesCombo().getSelectedItem().toString().equals(Messages.getString("WowEntry.17")))
			entry.add(new Float(0));
		else
			entry.add(new Float(getWhatField().getText()));
		entry.add(new String(getWhomField().getText()));
		
		return entry;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
