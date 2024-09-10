DO $$ 
BEGIN
   IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'bdd-accounts') THEN
      PERFORM dblink_exec('dbname=postgres user=postgres password='' ', 
                          'CREATE DATABASE "bdd-accounts"');
   END IF;
END $$;