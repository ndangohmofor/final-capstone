#!/bin/bash
BASEDIR=$(dirname $0)
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres workout &&
psql -U postgres -d workout -f "$BASEDIR/schema.sql" &&
psql -U postgres -d workout -f "$BASEDIR/user.sql" &&
psql -U postgres -d workout -f "$BASEDIR/data.sql"