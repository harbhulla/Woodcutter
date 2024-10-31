import net.eternalclient.api.accessors.Skills;
import net.eternalclient.api.utilities.Log;
import net.eternalclient.api.wrappers.map.WorldTile;
import net.eternalclient.api.wrappers.skill.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum Tree {
    TREES_1("Tree", 1, new WorldTile(3196, 3368, 0)),
    OAK_TREES_1("Oak tree", 15, new WorldTile(3101, 3245, 0)),
    WILLOW_TREES_1("Willow tree", 30, new WorldTile(3163, 3269, 0)),
    YEW_TREES_2("Yew tree", 60, new WorldTile(3206, 3502, 0));

    private final String name;
    private final int levelRequirement;
    private final WorldTile position;

    Tree(String tree, int i, WorldTile worldTile) {
        this.name = tree;
        this.levelRequirement = i;
        this.position = worldTile;

    }
    public int getLevelRequirement() {
        return levelRequirement;
    }
    public String getName() {
        return name;
    }
    public WorldTile getPosition() {
        return position;
    }

    public static List<Tree> getUsable() {
        int level = Skills.getRealLevel(Skill.WOODCUTTING);

        List<Tree> tree = new ArrayList<>();
        for (Tree t : Tree.values()) {
            if (t.levelRequirement <= level) {
                tree.add(t);
            }
        }

        return tree;
    }

    public static Tree getRandomHighestLevelTree() {
        List<Tree> usableTrees = getUsable();

        if (usableTrees.isEmpty()) {
            return null;
        }

        int highestLevel = usableTrees.stream()
                .mapToInt(Tree::getLevelRequirement)
                .max()
                .orElse(-1);

        List<Tree> highestLevelTrees = usableTrees.stream()
                .filter(tree -> tree.getLevelRequirement() == highestLevel)
                .collect(Collectors.toList());
        return highestLevelTrees.get(highestLevelTrees.size() - 1);
    }
}

