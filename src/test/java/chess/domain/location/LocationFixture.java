package chess.domain.location;

public class LocationFixture {

    public static final Location CENTER = new Location(Row.valueOf(3), Column.valueOf(3));
    public static final Location UP = new Location(Row.valueOf(4), Column.valueOf(3));
    public static final Location DOWN = new Location(Row.valueOf(2), Column.valueOf(3));
    public static final Location LEFT = new Location(Row.valueOf(3), Column.valueOf(2));
    public static final Location RIGHT = new Location(Row.valueOf(3), Column.valueOf(4));
    public static final Location UP_RIGHT = new Location(Row.valueOf(4), Column.valueOf(4));
    public static final Location UP_LEFT = new Location(Row.valueOf(4), Column.valueOf(2));
    public static final Location DOWN_RIGHT = new Location(Row.valueOf(2), Column.valueOf(4));
    public static final Location DOWN_LEFT = new Location(Row.valueOf(2), Column.valueOf(2));
    public static final Location UP_UP_RIGHT = new Location(Row.valueOf(5), Column.valueOf(4));
    public static final Location UP_UP_LEFT = new Location(Row.valueOf(5), Column.valueOf(2));
    public static final Location DOWN_DOWN_RIGHT = new Location(Row.valueOf(1), Column.valueOf(4));
    public static final Location DOWN_DOWN_LEFT = new Location(Row.valueOf(1), Column.valueOf(2));
    public static final Location RIGHT_RIGHT_UP = new Location(Row.valueOf(4), Column.valueOf(5));
    public static final Location RIGHT_RIGHT_DOWN = new Location(Row.valueOf(2), Column.valueOf(5));
    public static final Location LEFT_LEFT_UP = new Location(Row.valueOf(4), Column.valueOf(1));
    public static final Location LEFT_LEFT_DOWN = new Location(Row.valueOf(2), Column.valueOf(1));

    private LocationFixture() {

    }
}
