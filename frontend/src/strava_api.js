function getActivities(){
    const activites_link = "https://www.strava.com/api/v3/athlete?access_token=8038e53941ff70194a0d96349f1cf4a31f27e593"
    fetch(activites_link)
        .then((res) => console.log(res.json()))
}

getActivities()