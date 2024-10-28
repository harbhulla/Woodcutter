import net.eternalclient.api.frameworks.tree.Tree;
import net.eternalclient.api.script.AbstractScript;
import net.eternalclient.api.script.ScriptCategory;
import net.eternalclient.api.script.ScriptManifest;

@ScriptManifest(
        name = "Brocks Woodcutter",
        author = "EternalClient",
        description = "Powerlevelling Woodcutting",
        category = ScriptCategory.RUNECRAFTING,
        version = 1.0
)
public class Main extends AbstractScript
{

    private final Tree tree = new Tree();

    @Override
    public void onStart(String... args)
    {
        tree.addBranches(
                new WoodcuttingBranch().addLeafs(
                        new BankingLeaf(),
                        new WoodcuttingLeaf()
                )
        );
    }

    @Override
    public int onLoop()
    {
        // Run our logic tree
        return tree.onLoop();
    }

}