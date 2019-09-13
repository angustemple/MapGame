package curtin.edu.au.mapgame.Model;

public class GameMap
{
    private Area[][] grid;

    // CONSTRUCTOR ---------------------------------------------------------------------------------
    public GameMap()
    {
        this.grid = new Area[4][4];
        initialiseArray();
        createAreaItems();
    }

    // ACCESSORS -----------------------------------------------------------------------------------
    public Area getArea(int row, int col)
    {
        return grid[row][col];
    }

    // MUTATORS ------------------------------------------------------------------------------------
    public void setArea(Area area, int x, int y)
    {
        grid[x][y] = area;
    }

    // SPECIFIC METHODS ----------------------------------------------------------------------------
    private void initialiseArray()
    {
        for(int ii = 0; ii < 4; ii++)
        {
            for(int jj = 0; jj < 4; jj++)
            {
                grid[ii][jj] = new Area();
            }
        }
    }

    private void createAreaItems()
    {
        // Set Towns in three locations
        // No Items in this town
        grid[0][1].setTown(true);
        // Road Map found in this town
        grid[1][3].setTown(true);
        // Ice-Scraper found in this town
        grid[3][1].setTown(true);

        // Create Essential Items
        Equipment jadeMonkey = new Equipment("Jade Monkey", 100, 2.00);
        Equipment iceScraper = new Equipment("Ice Scraper", 10, 0.50);
        Equipment roadMap = new Equipment("Road Map", 25, 0.25);

        // Drop Essential Items in towns
        grid[1][3].addItem(roadMap);
        grid[3][1].addItem(iceScraper);
        // Drop final essential item in wilderness
        grid[1][1].addItem(jadeMonkey);

        // Create some non-essential items
        Equipment flashlight = new Equipment("Flash Light, Black", 10, 1.00);
        Equipment rope = new Equipment("Thick Rope, Beige", 5, 2.00);
        Equipment macbook = new Equipment("Macbook Pro 2018, broken keyboard", 5000, 3.00);

        // Put non essential items in random locations
        grid[0][0].addItem(flashlight);
        grid[2][3].addItem(rope);
        grid[2][2].addItem(macbook);

        // Create some food items, put in town in grid[0][0]
        Food apple = new Food("Red Apple", 1, 5.00);
        Food apple2 = new Food("Red Apple", 1, 5.00);
        Food apple3 = new Food("Red Apple", 1, 5.00);
        Food steak = new Food("Cooked steak", 5, 25.00);
        Food lasagne = new Food("Cold lasagne", 6, 30.00);

        // Put food items in town
        grid[0][1].addItem(apple);
        grid[0][1].addItem(apple2);
        grid[0][1].addItem(apple3);
        grid[0][1].addItem(steak);
        grid[0][1].addItem(lasagne);
    }
}
