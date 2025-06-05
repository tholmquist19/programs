from flask import Flask, render_template, url_for

app = Flask(__name__)

users = {
    "Pasta_Slurper": {
        "name": "Pasta_Slurper",
        "avatar": "profiles/alice.jpg",
        "bio": "Food lover. Pasta is life.",
    },
    "Burger_Lover24": {
        "name": "Burger_Lover24",
        "avatar": "profiles/bob.jpg",
        "bio": "Burger connoisseur and spice hunter.",
    },
    "DonutGlazer4": {
        "name": "DonutGlazer4",
        "avatar": "profiles/carol.jpg",
        "bio": "Sweet tooth. Lives for donuts.",
    },
    "PulledPorkFan13": {
        "name": "PulledPorkFan13",
        "avatar": "profiles/alice.jpg",
        "bio": "Man I love Pork",
        
    },
     "Mr.Ghetti": {
        "name": "Mr.Ghetti",
        "avatar": "profiles/alice.jpg",
        "bio": "From a long line of noodles",
        
    },
    "PicklePrincess": {
        "name": "PicklePrincess",
        "avatar": "profiles/alice.jpg",
        "bio": "Pickle Enthusiast",
        
    },
    "Coffee_mater": {
        "name": "Coffee_mater",
        "avatar": "profiles/alice.jpg",
        "bio": "Just somethin about caffiene",
        
    }
}

posts = [
    {
        "username": "Pasta_Slurper",
        "content": "Just made the best spaghetti ever",
        "image": "uploads/spaghetti.jpg",
        "timestamp": "2 hours ago",
        "comments": [
            {"user": "Mr.Ghetti", "text": "That looks amazing!"}
        ]
    },
    {
        "username": "Burger_Lover24",
        "content": "This burger's got it goin on",
        "image": "uploads/burger.jpg",
        "timestamp": "5 hours ago",
        "comments": [
            {"user": "PulledPorkFan13", "text": "That could use some more meat"},
            {"user": "PicklePrincess", "text": "You're missing the best ingredient!"}
        ]
    },
    {
        "username": "Pasta_Slurper",
        "content": "Love a good homemade sauce",
        "image": "uploads/pasta.jpg",
        "timestamp": "1 day ago",
        "comments": [
            {"user": "Mr.Ghetti", "text": "I want some of that!"}
        ]
    },
    {
        "username": "DonutGlazer4",
        "content": "Kind of wanted to keep this one to myself but figured I'd share",
        "image": "uploads/donut.jpg",
        "timestamp": "3 days ago",
        "comments": [
            {"user": "Coffee_mater", "text": "That would look way better dripping in coffee"},
            {"user": "PicklePrincess", "text": "Not really into sweets but I like the look of that"}
        ]
    }
]

@app.route('/')
def index():
    user_data = {
        uname: {
            **info,
            "avatar": url_for('static', filename=info["avatar"])
        }
        for uname, info in users.items()
    }

    post_data = [
        {
            **post,
            "image": url_for('static', filename=post["image"])
        }
        for post in posts
    ]

    return render_template('index.html', posts=post_data, users=user_data)

@app.route('/user/<username>')
def user_profile(username):
    user = users.get(username)
    if not user:
        return "User not found", 404

    user_data = {
        **user,
        "avatar": url_for('static', filename=user["avatar"])
    }

    user_posts = [
        {
            **post,
            "image": url_for('static', filename=post["image"])
        }
        for post in posts if post['username'] == username
    ]

    return render_template('profile.html', user=user_data, posts=user_posts)

if __name__ == '__main__':
    app.run(debug=True)
