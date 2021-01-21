let versionCompare = function (versions) {
    for (let i = 0; i < versions.length-1; i++){
        for (let j = 0; j < versions.length - i - 1; j++){
            
            if (compareVersion(versions[j], versions[j + 1])) {
                let temp = versions[j+1];
                versions[j + 1] = versions[j];
                versions[j] = temp;
            }
        }
    }
    return versions;
}

let compareVersion = function (ver1, ver2) {

    let ver1Split = ver1.split('.');
    let ver2Split = ver2.split('.');

    for (let i = 0; i < ver1Split.length; i++)
    {
        if (i > ver2Split.length - 1) {
            return true;
        }    
        
        if (ver2Split[i] < ver1Split[i]) {
            return true;
        }
        if (ver2Split[i] > ver1Split[i]) {
            return false;
        }
    }
    return false;
}

console.log(versionCompare(["3.0.1","3.2.4","3.0","1.1","1.0.0", "2.0.2",]));