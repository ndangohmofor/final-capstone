#!/bin/bash
BASEDIR=$(dirname $0)
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres workout &&
<<<<<<< HEAD
psql -U postgres -d  workout -f "$BASEDIR/schema.sql" &&
psql -U postgres -d workout -f "$BASEDIR/user.sql" &&
psql -U postgres -d workout -f "$BASEDIR/data.sql"
=======
psql -U postgres -d workout -f "$BASEDIR/schema.sql" &&
psql -U postgres -d workout -f "$BASEDIR/user.sql" &&
psql -U postgres -d workout -f "$BASEDIR/data.sql"
>>>>>>> 9587b3ae3c08239ccc550d94e550a4a6a2c242da
