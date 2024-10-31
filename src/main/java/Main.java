import net.eternalclient.api.accessors.Skills;
import net.eternalclient.api.frameworks.tree.Tree;
import net.eternalclient.api.script.AbstractScript;
import net.eternalclient.api.script.ScriptCategory;
import net.eternalclient.api.script.ScriptManifest;
import net.eternalclient.api.utilities.paint.CustomPaint;
import net.eternalclient.api.listeners.Painter;
import net.eternalclient.api.utilities.Timer;
import net.eternalclient.api.wrappers.skill.Skill;

import java.awt.*;
import java.util.ArrayList;

@ScriptManifest(
        name = "Brocks Woodcutter",
        author = "EternalClient",
        description = "FUCK",
        category = ScriptCategory.WOODCUTTING,
        version = 1.0
)
public class Main extends AbstractScript implements Painter
{
    private static final Timer startTimer = new Timer();
    private static final Tree tree = new Tree();
    private static final CustomPaint paint = new CustomPaint()
            .setInfoSupplier(() -> new ArrayList<String>()
            {{
                add(getScriptName() + " v" + getScriptVersion());
                add("Runtime: " + startTimer);
                add("Current Branch: " + Tree.currentBranch);
                add("Current Leaf: " + Tree.currentLeaf);
                add("Current Level: " + Skills.getRealLevel(Skill.WOODCUTTING));
            }}.toArray(new String[0]));

    @Override
    public void onStart(String... args)
    {
        tree.addBranches(
                new WoodcuttingBranch()
        );
    }

    @Override
    public int onLoop()
    {
        // Run our logic tree
        return tree.onLoop();
    }

    @Override
    public void onPaint(Graphics2D graphics2D) {
        paint.paint(graphics2D);
    }

}