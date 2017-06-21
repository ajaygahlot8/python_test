#!/usr/bin/python
# -*- coding: utf-8 -*-
import praw
import pprint
import datetime


def time_format(r_time):
    return datetime.datetime.fromtimestamp(int(r_time)).strftime('%Y-%m-%d %H:%M:%S'
            )


def bot_login():
    r = praw.Reddit(username='cuzok', password='reddit',
                    client_id='yl8xU18CjRzF5w',
                    client_secret='U4svRaf5cd8lOe6p92aX6MAvNaA',
                    user_agent='cuzoks first reddit bot v1.0')
    return r


r = bot_login()
print(r)

subreddit = r.subreddit('askreddit')
print (subreddit)

for submissions in subreddit.top(limit = 30):
    print (submissions.title)

    # pprint.pprint(vars(submissions))
    print(
    datetime.datetime.fromtimestamp(
            int(submissions.created_utc)
           ).strftime('%Y-%m-%d %H:%M:%S')
            )
