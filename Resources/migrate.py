import csv, sqlite3
import os
import time
from time import mktime
from datetime import datetime

DB_FILE_NAME = 'gps_rama4.db'
FILES_LIST = ['gps_rama4_20191118_20191130.csv','gps_rama4_20191201_20191202.csv']

if __name__ == '__main__':
    if os.path.exists(DB_FILE_NAME):
        print("Deleteing Existing Database")
        os.remove(DB_FILE_NAME)
    print("initializing...")
    con = sqlite3.connect(DB_FILE_NAME)
    cur = con.cursor()
    cur.execute("CREATE TABLE gps (deviceId,lat,lng,speed,direction,error,acc,meter,ts);") 
    for f in FILES_LIST:
        try:
            with open(f,'r') as fin: 
                print(f'migrating file {f}')
                dr = csv.DictReader(fin)
                for r in dr:
                    row = (r['deviceId'], float(r['lat']),float(r['lng']), float(r['speed']), float(r['direction']), float(r['error']), r['acc'], r['meter'], datetime.fromtimestamp(mktime(time.gmtime(int(r['ts'])))))
                    cur.execute("INSERT INTO gps (deviceId, lat, lng, speed, direction, error, acc, meter, ts) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);",row)
        except FileNotFoundError:
            print(f'Could not find {f}')
        except: 
            print("Error")
    con.commit()
    con.close()
    print("Done!")