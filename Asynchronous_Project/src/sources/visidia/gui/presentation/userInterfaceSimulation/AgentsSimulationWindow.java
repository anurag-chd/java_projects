package sources.visidia.gui.presentation.userInterfaceSimulation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sources.visidia.gui.DistributedAlgoSimulator;
import sources.visidia.gui.donnees.GuiProperty;
import sources.visidia.gui.donnees.TableImages;
import sources.visidia.gui.donnees.conteneurs.Ensemble;
import sources.visidia.gui.donnees.conteneurs.MultiEnsemble;
import sources.visidia.gui.metier.inputOutput.OpenAgentChooser;
import sources.visidia.gui.metier.inputOutput.OpenAgents;
import sources.visidia.gui.metier.inputOutput.OpenGraph;
import sources.visidia.gui.metier.inputOutput.OpenReport;
import sources.visidia.gui.metier.inputOutput.SaveFile;
import sources.visidia.gui.metier.simulation.AgentSimulEventHandler;
import sources.visidia.gui.metier.simulation.Convertisseur;
import sources.visidia.gui.presentation.FormeDessin;
import sources.visidia.gui.presentation.SelectionDessin;
import sources.visidia.gui.presentation.SommetCarre;
import sources.visidia.gui.presentation.SommetDessin;
import sources.visidia.gui.presentation.VueGraphe;
import sources.visidia.gui.presentation.boite.AbstractDefaultBox;
import sources.visidia.gui.presentation.boite.AgentBoxChangingVertexState;
import sources.visidia.gui.presentation.boite.AgentBoxProperty;
import sources.visidia.gui.presentation.boite.AgentBoxSimulationSelection;
import sources.visidia.gui.presentation.boite.AgentPulse;
import sources.visidia.gui.presentation.boite.BoiteChangementEtatArete;
import sources.visidia.gui.presentation.boite.DefaultBoxVertex;
import sources.visidia.gui.presentation.boite.ThreadCountFrame;
import sources.visidia.gui.presentation.starRule.StarRuleFrame;
import sources.visidia.gui.presentation.userInterfaceEdition.Editeur;
import sources.visidia.gui.presentation.userInterfaceEdition.Fenetre;
import sources.visidia.gui.presentation.userInterfaceEdition.Traitements;
import sources.visidia.rule.RSOptions;
import sources.visidia.rule.RelabelingSystem;
import sources.visidia.simulation.ObjectWriter;
import sources.visidia.simulation.agents.AbstractStatReport;
import sources.visidia.simulation.agents.Agent;
import sources.visidia.simulation.agents.AgentSimulator;
import sources.visidia.simulation.rules.AbstractRule;
import sources.visidia.simulation.synchro.SynCT;
import sources.visidia.simulation.synchro.synObj.SynObject;
import sources.visidia.tools.Bag;
import sources.visidia.tools.agents.UpdateTableStats;

/* Represents the algorithm simulation window for a graph */
public class AgentsSimulationWindow 
    extends Fenetre
    implements Serializable, ActionListener, WindowListener, ChangeListener,
               ApplyStarRulesSystem {
    
    protected static final String GENERAL_TITLE = "Agents Simulator";
    protected String algoTitle;
    
    // instance of simulator for stop/pause/start actions
    protected AgentSimulator sim;
    protected AgentSimulEventHandler seh;
    protected JToolBar toolBar;
    protected JButton but_start, but_pause, but_save, but_stop, but_help, but_experimentation, but_threadCount;
    protected JButton but_info , but_regles , but_reset;
    protected JButton but_default;
    protected JButton but_agents;
    protected AgentPulse global_clock;

    // save an execution
    protected ButtonGroup item_group;
    protected JRadioButtonMenuItem item_nothing, item_replay;
    protected ObjectWriter writer;
    
    protected JMenuItem item_chose, item_file;
    protected ThreadGroup tg=null;
    
    protected JMenuBar menuBar;
    protected JMenu file , rules ,  graph,algo;
    protected JMenuItem graph_open, algo_open, algo_placeAgent, algo_open_vertices, graph_save , graph_save_as , 
	file_quit , file_close, file_help, graph_select_all, graph_disconnect, graph_reconnect;
    protected JMenuItem rules_open, rules_new;
    //protected JMenuItem new_simple_rules ;
    //protected JMenuItem new_star_rules ;
    // Menu pour les options au niveau de la visualisation
    protected JMenu visualizationOptions ;
    // for the speed scale
    //     protected ChoiceMessage2 choiceMessage;
    protected JMenuItem synchro, others;
    protected JSlider speed_slider;
    protected JLabel speed_label;
    
    /** Panel where the VueGraphe is drawn*/
    protected AgentsSimulationPanel simulationPanel;
    protected File fichier_rules_edite;
    
    /* event pipe for events coming from the simulator */
    protected visidia.tools.VQueue evtPipeIn ;
    /* event pipe for events coming from the Recorder */
    protected visidia.tools.VQueue evtPipeOut ;
    /* ack pipe for acks coming from the graphic interfacs */
    protected visidia.tools.VQueue ackPipeIn ;
    /* ack pipe for acks coming from the Recorder */
    protected visidia.tools.VQueue ackPipeOut ;
    
    /*list of rewriting rules which could be either simple either stared */
    protected Vector rulesList  ;
    protected boolean[][] edgesStates = null;
    protected AbstractRule rsAlgo; // The algorithm witch will simulate the relabeling system

    protected static ThreadCountFrame threadCountFrame;
    public static boolean visuAlgorithmMess = true;
    public static boolean visuSynchrMess = true;
    public Editeur editeur;

    protected Hashtable agentsTable;
    protected Vector<RelabelingSystem> agentsRules = null;
        
    protected Hashtable<SommetDessin,AgentBoxChangingVertexState> boxVertices; // To store the
                                     // AgentBoxChangingVertex for
                                     // each SommetDessin (needed for automatic refresh)

    private Hashtable<String,Object> defaultProperties; // To initialize the whiteboards

    private UpdateTableStats timer;

    private Vector<AgentBoxProperty> boxAgents;

    public AgentsSimulationWindow(VueGraphe grapheVisu_edite, File fichier_edit,Editeur editeur) {
        
        this(grapheVisu_edite, COULEUR_FOND_PAR_DEFAUT, DIM_X_PAR_DEFAUT,
	     DIM_Y_PAR_DEFAUT, fichier_edit);
        this.addWindowListener(this);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setSize(DIM_X_PAR_DEFAUT, DIM_Y_PAR_DEFAUT);
        this.pack();
        this.setVisible(true);
	this.editeur = editeur;
    }
    
    
    public AgentsSimulationWindow(VueGraphe grapheVisu_edite , Color couleur_fond, int dim_x,
                                  int dim_y, File fichier_edit) {
        
        super();

	//tmp tmp tmp
	GuiProperty.drawNbr = true;


        evtPipeIn = new visidia.tools.VQueue();
        evtPipeOut = new visidia.tools.VQueue();
        ackPipeIn = new visidia.tools.VQueue();
        ackPipeOut = new visidia.tools.VQueue();

        writer = new ObjectWriter();
        
        tg = new ThreadGroup("recorder");
        
        // The edited graph and the selection object which contains selected objects
        vueGraphe = grapheVisu_edite;
        selection = new SelectionDessin();
        
	agentsTable = new Hashtable();

        boxVertices = new Hashtable();
        boxAgents = new Vector();
        defaultProperties = new Hashtable();
        
	// The manager of components
        content = new JPanel();
        content.setLayout(new BorderLayout());
        fichier_edite = fichier_edit;
        mettreAJourTitreFenetre();
        rulesList = new Vector();
        
        // The menu bar
        this.addMenu();
        // Current datas of the edition
        
        // BackGround Color of the GrapheVisuPanel
        couleur_de_fond = couleur_fond;
        
        // The edited graph and the selection object which contains selected objects
        vueGraphe = grapheVisu_edite;
        selection = new SelectionDessin();
        
	// The panel where the graph is drawn
        simulationPanel = new AgentsSimulationPanel(this);
        super.setSize(DIM_X_PAR_DEFAUT,DIM_Y_PAR_DEFAUT);
        // un setSize est a faire avant l'ajout de composants pour eviter
        // les warnings
        scroller = new JScrollPane(simulationPanel);
        scroller.setPreferredSize(new Dimension(DIM_X_PAR_DEFAUT,DIM_Y_PAR_DEFAUT));
        simulationPanel.revalidate();
        
        simulationPanel.scrollRectToVisible(new Rectangle((vueGraphe.donnerDimension()).width-10,(vueGraphe.donnerDimension()).height-10,30,30));
        simulationPanel.repaint();
        
        scroller.setOpaque(true);
        content.add(scroller, BorderLayout.CENTER);
        
        this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		    setVisible(false);
		    dispose();
		    // Running the garbage collector
		    Runtime.getRuntime().gc();
                
		}
	    });
        
        // The tool bar
        this.addToolBar();
        
        // On disable les items non-valide pour une applet
        if(!DistributedAlgoSimulator.estStandalone())
            disableButtonForApplet();
        
        
        this.setContentPane(content);
    }

    
    /**
     *
     **/
    public void addAgents(Integer id, String agent) {

	boolean ok;
	SommetDessin vert = getVueGraphe().rechercherSommet(id.toString());
	int nbr;
	
	if(!agentsTable.containsKey(id)) {
	    agentsTable.put(id, new ArrayList());
	}
	ok = ((ArrayList)agentsTable.get(id)).add(agent);
	
	vert.changerCouleurFond(Color.red);
	
	nbr = ((ArrayList)agentsTable.get(id)).size();
	String nbrStr = new String().valueOf(nbr);
	
	((SommetCarre)vert).setNbr(nbrStr);
	
	this.simulationPanel().repaint();
	
    }


    /**
     * This method adds the Menu bar, its menus and items to the editor
     **/
    
    protected void addMenu() {
        
        menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(650, 20));
        
        // Build the menu File
        file = new JMenu("File");
        file.getPopupMenu().setName("PopFile");
        file.setMnemonic('F');
        
        file_help = new JMenuItem("Help", KeyEvent.VK_H);
        file_help.setAccelerator(KeyStroke.getKeyStroke(
							KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        file_help.addActionListener(this);
        file.add(file_help);
        file.addSeparator();
        file_close = new JMenuItem("Close", KeyEvent.VK_C);
        file_close.setAccelerator(KeyStroke.getKeyStroke(
							 KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        file_close.addActionListener(this);
        file.add(file_close);
        file_quit = new JMenuItem("Quit", KeyEvent.VK_Q);
        file_quit.setAccelerator(KeyStroke.getKeyStroke(
							KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        file_quit.addActionListener(this);
        file.add(file_quit);
        file.addActionListener(this);
        menuBar.add(file);
        graph = new JMenu("Graph");
        graph.getPopupMenu().setName("PopGraph");
        graph.setMnemonic('G');
        
        graph_open = new JMenuItem("Open graph ", KeyEvent.VK_O);
        graph_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        graph_open.addActionListener(this);
        graph.add(graph_open);
        
        graph_save = new JMenuItem("Save Graph");
        graph_save.addActionListener(this);
        graph.add(graph_save);
        
        graph_save_as = new JMenuItem("Save graph as...");
        graph_save_as.addActionListener(this);
        graph.add(graph_save_as);
        graph.addActionListener(this);
	menuBar.add(graph);
	
	graph.addSeparator();
	
	// graphe connection and disconnection
	
	/*graph_disconnect = new JMenuItem("Disconnect");
	  graph_disconnect.addActionListener(this);
	  graph_disconnect.setToolTipText("Disconnect the selected elements");
	  graph.add(graph_disconnect);
	  graph_reconnect = new JMenuItem("Reconnect");
	  graph_reconnect.addActionListener(this);
	  graph_reconnect.setToolTipText("Reconnect the selected elements");
	  graph.add(graph_reconnect);*/
	
	graph_select_all = new JMenuItem("Select all");
	graph_select_all.addActionListener(this);
	graph_select_all.setToolTipText("Select all the elements of the graph");
	graph.add(graph_select_all);

        graph.addActionListener(this);
        menuBar.add(graph);

 
        algo = new JMenu("Agents"); //!!
        algo.getPopupMenu().setName("PopAlgo");
        algo.setMnemonic('A');
        
        algo_open = new JMenuItem("Add Agents...");
        algo_open.addActionListener(this);
        algo.add(algo_open);

        algo_placeAgent = new JMenuItem("Place Agents...");
        algo_placeAgent.addActionListener(this);
        algo.add(algo_placeAgent);

        algo.setEnabled(vueGraphe.getGraphe().ordre()>0); // if we have an empty graph
        
	algo.addActionListener(this);
	menuBar.add(algo);
        
	rules = new JMenu("Rules");
	rules.getPopupMenu().setName("PopRules");
	rules.setMnemonic('R');
	
	rules_new = new JMenuItem("New relabeling system");
	rules_new.addActionListener(this);
	rules.add(rules_new);
	
	rules_open = new JMenuItem("Open rules...");
	rules_open.addActionListener(this);
	rules.add(rules_open);
	
	menuBar.add(rules);
        
        /*
	  visualizationOptions  = new VisualizationOptions(this);
	  menuBar.add(visualizationOptions);
         
	*/
        
        this.setJMenuBar(menuBar);
    }
    /**
     * This method adds the tool bar and its buttons to the editor
     **/
    protected void addToolBar() {
        
        toolBar = new JToolBar();
        toolBar.setBackground(new Color(120, 120, 120));
        toolBar.setOpaque(true);
        toolBar.setPreferredSize(new Dimension(650, 42));
        
        this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		    commandeClose();
		}
	    });
        
        //Build buttons on the tool bar
        but_start = new JButton("start");
        but_start.setToolTipText("Start");
        but_start.setAlignmentY(CENTER_ALIGNMENT);
        but_start.setEnabled(false);
        but_start.addActionListener(this);
        toolBar.add(but_start);
        
        but_pause = new JButton("pause");
        but_pause.setToolTipText("Pause");
        but_pause.setAlignmentY(CENTER_ALIGNMENT);
        but_pause.setEnabled(false);
        but_pause.addActionListener(this);
        toolBar.add(but_pause);
        
        but_stop = new JButton("stop");
        but_stop.setToolTipText("Stop");
        but_stop.setAlignmentY(CENTER_ALIGNMENT);
        but_stop.addActionListener(this);
        but_stop.setEnabled(false);
        toolBar.add(but_stop);
        
        toolBar.addSeparator();
        but_save = new JButton("save");
        but_save.setToolTipText("Save");
        but_save.setAlignmentY(CENTER_ALIGNMENT);
        but_save.addActionListener(this);
        toolBar.add(but_save);
        

        toolBar.addSeparator();
        
        // slider for speed modification
        speed_slider = new JSlider(1, 5, 2);
        speed_slider.addChangeListener(this);
        speed_slider.setToolTipText("Speed");
        speed_slider.setAlignmentY(TOP_ALIGNMENT);
        speed_slider.setAlignmentX(LEFT_ALIGNMENT);
        speed_slider.setPreferredSize(new Dimension(80,15));
        speed_slider.setBackground(toolBar.getBackground().brighter());
        JPanel speed_panel = new JPanel();
        
        speed_panel.setMaximumSize(new Dimension(85,40));
        speed_panel.setBackground(toolBar.getBackground());
        speed_label = new JLabel("Speed ("+simulationPanel.pas()+")");
        speed_label.setFont(new Font("Dialog",Font.BOLD,10));
        speed_label.setToolTipText("Speed");
        speed_label.setAlignmentY(TOP_ALIGNMENT);
        speed_label.setForeground(Color.black);
        speed_panel.add(speed_slider);
        speed_panel.add(speed_label);
        
        toolBar.add(speed_panel);

        toolBar.addSeparator();

   
        but_info = new JButton(new ImageIcon(TableImages.getImage("vertexwb")));
        but_info.setToolTipText("Info");
        but_info.setAlignmentY(CENTER_ALIGNMENT);
        but_info.addActionListener(this);
        toolBar.add(but_info);

        but_default = new JButton(new ImageIcon(TableImages.getImage("vertexdefwb")));
        but_default.setToolTipText("Initialisation");
        but_default.setAlignmentY(CENTER_ALIGNMENT);
        but_default.addActionListener(this);
        toolBar.add(but_default);
        
        toolBar.addSeparator();
        
        but_agents = new JButton(new ImageIcon(TableImages.getImage("agentwb")));
        but_agents.setToolTipText("Agent whiteboard");
        but_agents.setAlignmentY(CENTER_ALIGNMENT);
        but_agents.setEnabled(false);
        but_agents.addActionListener(this);
        toolBar.add(but_agents);
        
        toolBar.addSeparator();


        but_help = new JButton(new ImageIcon(TableImages.getImage("help")));
        but_help.setToolTipText("Help");
        but_help.setAlignmentY(CENTER_ALIGNMENT);
        but_help.addActionListener(this);
        toolBar.add(but_help);
        
        toolBar.addSeparator();
        
        but_experimentation = new JButton("Statistics");
        but_experimentation.setToolTipText("Statistics");
        but_experimentation.setAlignmentY(CENTER_ALIGNMENT);
        but_experimentation.addActionListener(this);
        but_experimentation.setEnabled(false);
        toolBar.add(but_experimentation);
        toolBar.addSeparator();
        
        but_threadCount = new JButton("theads");
        but_threadCount.setToolTipText("amount of threads that are active in the VM");
        but_threadCount.setAlignmentY(CENTER_ALIGNMENT);
        but_threadCount.addActionListener(this);
        toolBar.add(but_threadCount);
        toolBar.addSeparator();
        if(threadCountFrame == null){
            threadCountFrame = new ThreadCountFrame(Thread.currentThread().getThreadGroup());
        }
        
        but_reset = new JButton("RESET");
        but_reset.setToolTipText("RESET");
        but_reset.setAlignmentY(CENTER_ALIGNMENT);
        but_reset.addActionListener(this);
        but_reset.setEnabled((fichier_edite != null));
        toolBar.add(but_reset);
        
	global_clock = new AgentPulse();

        content.add(toolBar, BorderLayout.NORTH);
	content.add(global_clock, BorderLayout.SOUTH);

    }
    
    
    // disable the button not used for the applet
    private void disableButtonForApplet(){
        file_quit.setEnabled(false);
        rules.setEnabled(false);
        graph.setEnabled(false);
        rules_new.setEnabled(false);
        but_save.setEnabled(false);
        but_experimentation.setEnabled(false);
    }
    
    
    
    /**********************************************************/
    /* Returns the panel "simulationPanel" which corresponds  */
    /*   to the graph visualisation during the simulation     */
    /**********************************************************/
    public AgentsSimulationPanel simulationPanel() {
        return simulationPanel;
    }
    
    /*********************************************************/
    /* Implementation of ActionListener interface            */
    /* treatment of what is done when pushing buttons or menu*/
    /*********************************************************/
    public void actionPerformed(ActionEvent evt) {
        
        if(evt.getSource() instanceof JButton)
            action_toolbar((JButton)evt.getSource());
        else if(evt.getSource() instanceof JMenuItem)
            action_menu((JMenuItem)evt.getSource());
    }
    
    /*********************************************************/
    /* Implementation of the ChangeListener interface        */
    /* action on the speed slider                            */
    /*********************************************************/
    public void stateChanged(ChangeEvent evt) {
        if (evt.getSource() == speed_slider) {
            speed_label.setText("Speed ("+speed_slider.getValue()+")");
            simulationPanel.updatePas(speed_slider.getValue());
        }
    }
    
    /*********************************************************/
    /* Method for making action corresponding                */
    /* to the menu used .                                    */
    /*********************************************************/
    public void action_menu(JMenuItem mi) {
        String le_menu = ((JPopupMenu)mi.getParent()).getName();
        
        if(le_menu == "PopFile") {
            menuFile(mi);}
        else if(le_menu == "PopGraph")
            menuGraph(mi);
        else if(le_menu == "PopAlgo")
            menuAlgo(mi);
        else if(le_menu == "PopRules")
            menuRules(mi);
        /*else if(le_menu == "PopRules_new")
	  menuNew(mi);*/
        
    }
    
    /*********************************************************/
    /*  Method for making action corresponding               */
    /* to the button of the toolBar used                     */
    /*********************************************************/

    public void but_start() {
	// deselect all selected elements
	selection.deSelect();

	// enable drawing on vertices the number of agents
	GuiProperty.drawNbr = true;
	
	simulationPanel.start();
	// modifications for the recorder
	sim = null;
	// destruction of ths old threads
	while(tg.activeCount() > 0) {
	    tg.interrupt();
	    try{
		Thread.currentThread().sleep(50);
	    }
	    catch(InterruptedException e){
	    }
	}
        
        sim = new AgentSimulator(Convertisseur
                                 .convert(vueGraphe.getGraphe(),
                                          agentsTable,
                                          defaultProperties),
                                 agentsRules,
                                 evtPipeOut, ackPipeOut);

        seh =  new AgentSimulEventHandler(this,evtPipeOut,ackPipeOut);
 	seh.start();

	but_stop.setEnabled(true);
	but_pause.setEnabled(true);
	but_start.setEnabled(false);

        but_agents.setEnabled(true);
        but_experimentation.setEnabled(true);

	algo_open.setEnabled(false); 
	algo_placeAgent.setEnabled(false);
	rules_open.setEnabled(false);
	rules_new.setEnabled(false);

        sim.startSimulation();

    }
    
    public void but_pause() {
	if(simulationPanel.isRunning()){
	    simulationPanel.pause();
            //dam 	    sim.wedge();
	}
	else {
	    simulationPanel.start();
            //dam 	    sim.unWedge();
	}
    }

    public void but_stop() {
	this.stopAll();

	evtPipeIn = new visidia.tools.VQueue();
	evtPipeOut = new visidia.tools.VQueue();
	ackPipeIn = new visidia.tools.VQueue();
	ackPipeOut = new visidia.tools.VQueue();
	
	but_start.setEnabled(false);
	but_pause.setEnabled(false);
	but_stop.setEnabled(false);
	but_reset.setEnabled(true);

        but_agents.setEnabled(false);


	global_clock.initState();
    }

    public void but_experimentation() {
	AgentExperimentationFrame statsFrame;
	Bag expStats;
	AbstractStatReport classStats = OpenReport.open(this);
	if (classStats == null)
	    return;
	if (sim == null) {
	    statsFrame = new AgentExperimentationFrame(vueGraphe, agentsTable, 
						       defaultProperties, agentsRules,
						       classStats);
	} else {
	    classStats.setStats(sim.getStats());
	    expStats = classStats.getStats();
	   	    
	    statsFrame = new AgentExperimentationFrame(expStats);
	    if (timer == null) {
		timer = new UpdateTableStats(sim, classStats, 
					     statsFrame.getTableModel());
		new Thread(timer).start();
	    }
            else {
                timer.setTableModel(statsFrame.getTableModel());
                timer.setStatReport(classStats);
            }
	}

        statsFrame.setTitle("Agents Experiments");
        statsFrame.pack();
        statsFrame.setVisible(true);

    }
    

    public void but_reset() {
	simulationPanel.stop();
	if (sim != null) {
 	    sim.abortSimulation();
            sim = null;
        }
        if (seh != null)
            seh.abort();
	
	/*
	  if (fichier_edite != null)
	  OpenGraph.open(this,fichier_edite);
	*/
	
        agentsTable.clear();

	vueGraphe = editeur.getGraphClone();
	
	evtPipeIn = new visidia.tools.VQueue();
	evtPipeOut = new visidia.tools.VQueue();
	ackPipeIn = new visidia.tools.VQueue();
	ackPipeOut = new visidia.tools.VQueue();
	replaceSelection(new SelectionDessin());
	simulationPanel.setPreferredSize(vueGraphe.donnerDimension());
	simulationPanel.revalidate();
	simulationPanel.scrollRectToVisible(new Rectangle(650,600,0,0));
	simulationPanel.repaint();
	
	//algo.setEnabled(vueGraphe.getGraphe().ordre()>0); // if we have an empty graph
	
	but_start.setEnabled(false);
	but_pause.setEnabled(false);
	but_stop.setEnabled(false);
	but_reset.setEnabled(true);
        but_experimentation.setEnabled(false);

	/* enable the button to add agents */
	algo_open.setEnabled(true); 
	algo_placeAgent.setEnabled(true);
	rules_open.setEnabled(true);
	rules_new.setEnabled(true);

	/* reinitialize the pulse counter */
	global_clock.initState();
	
    }

    public void action_toolbar(JButton b) {
        if (b == but_start){
	    but_start();
        }
        else if (b == but_pause) {
	    but_pause();
        }
	else if (b == but_stop) {
	    but_stop();
        }
	else if (b == but_experimentation){
	    but_experimentation();
        }
	else if (b == but_threadCount){
            threadCountFrame.pack();
            threadCountFrame.setVisible(true);
        }
	else if (b == but_save) {
            SaveFile.save(this, vueGraphe.getGraphe());
        }
        else if (b == but_info){
            propertiesControl();
        }
        else if (b == but_default){
            but_initWhiteboard();
        }
        else if (b == but_agents){
            but_agentsWhiteboard();
        }
	else if (b == but_help){
	    JOptionPane.showMessageDialog
		(this, "To Start the simulation you must fisrt add " +
		 "agents on one or more vertices.\n" + "\n" +
		 "To place agents on vertices according to a given " +
		 "probability :\n" + 
		 " use Place Agents ... in Agents menu.\n" + "\n" +
		 "To add chosen agents on chosen vertices :\n" + 
		 "you must select the vertices first then choose the agent" +
		 " using Add Agents...\n in the Agents menu.\n" +
		 "To start the simulation, press button start.\n" + "\n" +
		 "If you do not want graphical simulation, place your " +
		 "agents on the graph and\n" +
		 "click the 'Statistics' button\n" + "\n" +
		 " For more information about the agents please read " +
		 "the documentation given by \n" + "Javadoc or comments " +
		 "given in th classes.\n"
		 );
	}
	else if (b == but_reset) {
	but_reset();
	}
    }
    

    public void setPulse(int pulse) {
	//PulseFrame pulseFrame = new PulseFrame();
	//pulseFrame.setPulse(pulse);
	//global_clock.setToolTipText("Click to view time units");
	global_clock.setPulse(pulse);
    }


    /*************************************************************/
    /* Method for the fonctionnalities of the "File" menu.       */
    /*************************************************************/
    public void menuFile(JMenuItem mi) {
        
        
        if(mi == file_help) {
            JOptionPane.showMessageDialog(this,
					  "DistributedAlgoSimulator, v2\n" +
					  "in this window you can't modifie the graph \n"+
					  "except changing the state of edges or vertices\n"+
					  "before starting simulation you must load an algorithm \n "+
					  "or a list of simple rules \n");
        }
        else if(mi == file_close)
            commandeClose();
        else if(mi == file_quit)
            System.exit(0);
    }
    
    /*************************************************************/
    /* Method for the fonctionnalities of the "graph" menu.      */
    /*************************************************************/
    public void menuGraph(JMenuItem mi) {
        if(mi == graph_open){
            OpenGraph.open(this);
            algo.setEnabled(vueGraphe.getGraphe().ordre()>0); // if we have an empty graph
            //             algoChoice = new AlgoChoice(vueGraphe.getGraphe().ordre());
            replaceSelection(new SelectionDessin());
            simulationPanel.setPreferredSize(vueGraphe.donnerDimension());
            simulationPanel.revalidate();
            simulationPanel.scrollRectToVisible(new Rectangle(650,600,0,0));
            simulationPanel.repaint();
            if (item_replay.isSelected()) {
                but_start.setEnabled(true);
                but_experimentation.setEnabled(true);
            }
            else
                but_start.setEnabled(false);
            but_pause.setEnabled(false);
            but_stop.setEnabled(false);
        }
        
        else if(mi == graph_save) {
            
            SaveFile.save(this, vueGraphe.getGraphe());
        }
        else if(mi == graph_save_as) {
            fichier_edite = null;
            SaveFile.saveAs(this, vueGraphe.getGraphe());
        }
	else if (mi == graph_select_all) {
	    //PFA2003
	    Enumeration e = vueGraphe.listeAffichage();
	    while(e.hasMoreElements()) {
		FormeDessin objetVisu = (FormeDessin)e.nextElement();
		selection.insererElement(objetVisu);
	    }
	    repaint ();
	}
    }
    
    /*************************************************************/
    /* Method for the fonctionnalities of the "Algo" menu.       */
    /*************************************************************/
    public void menuAlgo(JMenuItem mi) {

	//nada jb
        //         if (mi == algo_open_vertices){
        //             if (!selection.estVide()){
        //                 if(DistributedAlgoSimulator.estStandalone()){
        //  //                    OpenAlgo.openForVertex(selection.elements(),this);
        //                     System.out.println("choix de l'algo reussi");}
        //                 else
        //  //                    OpenAlgoApplet.openForVertices(selection.elements(),this);
        //                 but_start.setEnabled(algoChoice.verticesHaveAlgorithm());
        //             }
        //         }
        if(mi == algo_open){
            boolean ok = true;
            
            if(selection.estVide()) {
                JOptionPane
                    .showMessageDialog(this,
                                       "You must select at least one"
                                       + " vertex!",
                                       "Warning",
                                       JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if(DistributedAlgoSimulator.estStandalone())
                ok = OpenAgents.open(selection.elements(),this);
            else
                //                    OpenAlgoApplet.open(this);
                ;
            
            if(! but_start.isEnabled()) {
                but_start.setEnabled(ok);
                but_experimentation.setEnabled(ok);
            }
            
        }
        
        if (mi == algo_placeAgent) {
            boolean ok = true;

            ok = OpenAgentChooser.open(this);

            if(! but_start.isEnabled()) {
                but_start.setEnabled(ok);
                but_experimentation.setEnabled(ok);
            }
        }
    }
    
    /*************************************************************/
    /* Method for the fonctionnalities of the "rules" menu.      */
    /*************************************************************/
    public void menuRules(JMenuItem mi) {
        if(selection.estVide()) {
            JOptionPane
                .showMessageDialog(this,
                                   "You must select at least one"
                                   + " vertex!",
                                   "Warning",
                                   JOptionPane.WARNING_MESSAGE);
            return;
        }

	if (mi == rules_open) {
            final javax.swing.filechooser.FileFilter filter = 
                new javax.swing.filechooser.FileFilter () {
                    public boolean accept (File f) {
                        String n = f.getName ();
                        return n.endsWith ("srs");
                    }
                    public String getDescription () {
                        return "srs (star rules system) files";
                    }
                };
		
            JFileChooser chooser = new JFileChooser ();
            chooser.setDialogType (JFileChooser.OPEN_DIALOG);
            chooser.setFileFilter (filter);
            chooser.setCurrentDirectory (new File ("./"));
            int returnVal = chooser.showOpenDialog (this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    String fName = chooser.getSelectedFile().getPath();
                    FileInputStream istream = new FileInputStream(fName);
                    ObjectInputStream p = new ObjectInputStream(istream);
                    RelabelingSystem rSys = (RelabelingSystem) p.readObject();
                    istream.close();
                    applyStarRulesSystem(rSys);
                } catch (IOException ioe) {
                    System.out.println (ioe);
                } catch (ClassNotFoundException cnfe) {
                    System.out.println (cnfe);
                }
            }
        } else if (mi == rules_new) {
	    StarRuleFrame starRuleFrame = new StarRuleFrame((JFrame) this,
							    (ApplyStarRulesSystem) this);
	    starRuleFrame.setVisible(true);
	}
    }
    

    public void applyStarRulesSystem(RelabelingSystem rSys) {
	if (!rulesWarnings(rSys))
            return;

        if (agentsRules == null)
            agentsRules = new Vector();

	int size = agentsRules.size();
	
	agentsRules.add(rSys);

	Enumeration e = selection.elements();
	while (e.hasMoreElements()) {
	    int id;
	    id = Integer.decode(((SommetDessin)e.nextElement()).getEtiquette());
	    addAgents(id,"Agents Rules_" + size);
	}

	but_start.setEnabled(true);
        but_experimentation.setEnabled(true);
    }
    
    private void stopAll() {

	if (sim != null) {   // we kill the threads
	    
	    System.out.println("Stopping the timer");
	    if (timer != null) {
		timer.stop();
		timer = null;
	    }
	    
	    System.out.println("Stopping the Simulation panel");
	    simulationPanel.stop();
	    System.out.println("  ==> Stopped");
	    System.out.println("Stopping the Simulator");
	    if (sim != null)
		sim.abortSimulation();
	    
	    System.out.println("  ==> Stopped");
	    
	    System.out.println("Stopping the Simulator Event Handler");
	    seh.abort();
	    System.out.println(" ==> Stopped");
	    
            seh.abort();
	}
    }
    
    /********************************/
    /** Closing the current window **/
    /********************************/
    public void commandeClose() {

	Iterator it = boxAgents.iterator();
	while (it.hasNext()){
	    AgentBoxProperty box = (AgentBoxProperty)it.next();	
	    box.close();
	    it.remove();
	}
	
	this.stopAll();
	GuiProperty.drawNbr = false; 
        setVisible(false);
        dispose();
        // collecting the garbage
        Runtime.getRuntime().gc();
    }
    
    /**
     * Selection of all the graph
     */
    public void commandeToutSelectionner() { // Penser au repaint()
        int i = 0;
        Enumeration e = vueGraphe.listeAffichage();
        if (e.hasMoreElements()) {
            while(e.hasMoreElements()) {
                FormeDessin forme = (FormeDessin)e.nextElement();
                selection.insererElement(forme);
                forme.enluminer(true);
                i++;
            }
        }
    }
    
    /**
     * this method retrurns the string corresponding to the title of the
     * window
     **/
    /**********************************************************/
    /* this method permit to validate the reset button if a   */
    /* saving is made and then change the title of the window */
    /**********************************************************/
    public void mettreAJourTitreFenetre(File fichier) {
        if(fichier != null) but_reset.setEnabled(true);
        super.mettreAJourTitreFenetre(fichier);
    }

    public void mettreAJourTitreFenetre(String nom_Algo) {
	algoTitle = nom_Algo;
	super.mettreAJourTitreFenetre(nom_Algo);
    }

    
    protected String titre() {
        return "Algorithm Simulator";
    }
    
    public String getAlgoTitle() {
	return algoTitle;
    }

    public String type(){
        return "Simulator";
    }
    
    public File fichier_rules_edite() {
        return fichier_rules_edite;
    }
    
    // Implementation of the Listeners
    
    public void windowOpened(WindowEvent e) {}
    
    public void windowClosing(WindowEvent e) {}
    
    public void windowClosed(WindowEvent e) {}
    
    public void windowIconified(WindowEvent e) {}
    
    public void windowDeiconified(WindowEvent e) {}
    
    public void windowActivated(WindowEvent e) {content.repaint();}
    
    public void windowDeactivated(WindowEvent e) {}
    
    public void commandeSupprimer() { // Penser au repaint()
        
        // Deleting the elements of the selection
        if(!selection.estVide()) {
            Enumeration e = selection.elements();
            while (e.hasMoreElements()) {
                FormeDessin forme = (FormeDessin)e.nextElement();
                forme.delete();
            }
        }
        
    }
    
    private void replaceSelection(SelectionDessin new_selection) {
        // Deletes the initial selection and replaces it with the new one
        emptyCurrentSelection(true);
        selection = new_selection;
        selection.select();
    }
    
    
    /**
     * Method to empty the current selection
     */
    public void emptyCurrentSelection(boolean deselect) { // Penser au repaint()
        if (!selection.estVide())
            if (deselect) {
                selection.deSelect();
            }
    }
    
    // action on the property button with a selection
    
    private void propertiesControl() {
        if (selection.estVide())
            System.out.println("empty");
        else {
            Enumeration e = selection.elements();
            FormeDessin firstElement = ((FormeDessin)e.nextElement());
            if (!Traitements.sommetDessin(selection.elements()).hasMoreElements()) {
                // we have only edges
                e = selection.elements();
                Ensemble listeElements = new Ensemble();
                listeElements.inserer(e);
                //                 BoiteChangementCouleurArete boiteArete =
                // 		    new BoiteChangementCouleurArete(this, listeElements);
                BoiteChangementEtatArete boiteArete =
		    new BoiteChangementEtatArete(this, listeElements);

                boiteArete.show(this);
            }
            else if ((selection.nbElements() == 1) &&
		     (firstElement.type().equals("vertex"))){

                // if ( boxVertices.containsKey(firstElement) ) {
                //                     boxVertices.remove(firstElement);
                //                 }
                
                AgentBoxChangingVertexState agentBox = new AgentBoxChangingVertexState(this, (SommetDessin)firstElement, defaultProperties);
                boxVertices.put((SommetDessin)firstElement,agentBox);
                agentBox.show(this);
            }
            else{
                e = selection.elements();
                visidia.gui.donnees.conteneurs.MultiEnsemble table_des_types = new MultiEnsemble();
                while(e.hasMoreElements())
                    table_des_types.inserer(((FormeDessin)e.nextElement()).type());
		AgentBoxSimulationSelection.show(this, selection, table_des_types);
            }
        }
    }

    private void but_initWhiteboard() {
        DefaultBoxVertex defBox = new DefaultBoxVertex(this,defaultProperties);
        defBox.show(this);
    }

    private void but_agentsWhiteboard() {

        Object[] agents = sim.getAllAgents().toArray();
        
        Agent ag = (Agent) JOptionPane.showInputDialog(this,
                                                       "Select the agent:",
                                                       "Agent's whiteboard editor",
                                                       JOptionPane.PLAIN_MESSAGE,
                                                       null,
                                                       agents,
                                                       null);
        
        if (ag != null) {
            
            AgentBoxProperty agentBox = new AgentBoxProperty(this,ag.getWhiteBoard(),ag.toString());
            boxAgents.addElement(agentBox);
	    agentBox.show(this);
        }

    }


    public void removeWindow(AbstractDefaultBox box) {
        boxAgents.remove(box);
    }

    
    public void changerVueGraphe(VueGraphe grapheVisu){
        content.remove(scroller);
        selection.deSelect();
        this.vueGraphe = grapheVisu;
        this.simulationPanel = new AgentsSimulationPanel(this);
        simulationPanel.updatePas(speed_slider.getValue());
        scroller = new JScrollPane(this.simulationPanel);
        scroller.setPreferredSize(new Dimension(650,600));
        scroller.setOpaque(true);
        content.add(scroller, BorderLayout.CENTER);
    }
    
    public visidia.tools.VQueue getEvtPipe(){
        return evtPipeOut;
    }
    public visidia.tools.VQueue getAckPipe(){
        return ackPipeOut;
    }
    public void setEdgeState(int id1, int id2, boolean hasFailure) {
        edgesStates[id1][id2] = hasFailure;
    }
    
    public static void setVisuAlgorithmMess(boolean b){
        visuAlgorithmMess = b;
    }
    
    public static void setVisuSynchrMess(boolean b){
        visuSynchrMess = b;
    }
    
    
    public void nodeStateChanged(int nodeId, Hashtable properties) {
        //System.out.println("aaaa= "+nodeId+" gggg = "+ properties);
	if (sim != null)
            //dam 	    sim.setNodeProperties(nodeId, properties);
            ;
        //sim.restartNode(nodeId);
    }

    public boolean rulesWarnings(RelabelingSystem r){
	int synType;//user choice
	int type = -2;//default choice
	SynObject synob;
	RSOptions options = r.getOptions();

	if (options.defaultSynchronisation() != -1) {
	    type = r.defaultSynchronisation();
	    /* user choice */
	    synType = options.defaultSynchronisation();
            System.out.println("synType: " + synType + " type " + type);
            System.out.println("RDV: " + SynCT.RDV + " LC1 " + SynCT.LC1);
	    if ((synType  == SynCT.RDV) && (type == SynCT.LC1)) {
		JOptionPane.showMessageDialog
		    (this, "The rendez-vous synchronisation cannot be used\n" +
		     "because of context or arity", "Error",
		     JOptionPane.WARNING_MESSAGE);
	    }
	    if ((synType  == SynCT.LC1)&&(type== SynCT.RDV)){
		JOptionPane.showMessageDialog
		    (this, "The use of use of LC1 is not recommended :\n" +
		     "check if you modify the neighbors.", "Error",
		     JOptionPane.WARNING_MESSAGE);
	    }
	} else {
	    /* default option */
	    synType = r.defaultSynchronisation();
	}
        if (synType != SynCT.RDV || (type != -2 && type != SynCT.RDV)) {
            JOptionPane
                .showMessageDialog(this,
                                   "Only RDV rules can be currently used with"
                                   + " agents!",
                                   "Error",
                                   JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void updateVertexState(SommetDessin vert) {
        AgentBoxChangingVertexState box = 
            (AgentBoxChangingVertexState) boxVertices.get(vert);

        if (box!=null)          // An AgentBoxChangingVertexState is
            box.updateBox();    // open for this vertex

    }

    public Hashtable getDefaultProperties() {
        return defaultProperties;
    }

}
