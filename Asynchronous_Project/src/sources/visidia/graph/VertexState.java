package sources.visidia.graph;

public class VertexState extends SimpleGraphVertex {
    
    
    public StringNodeState nodeState;
    
    VertexState(StringNodeState nodeState) {
	nodeState = nodeState;
    }
    
    public void setNodeState(StringNodeState nodeState) {
	nodeState = nodeState;
    }

    public String getNodeState() {
	return nodeState.toString();
    }
}
