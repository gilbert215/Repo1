#!/bin/bash

USER_STORE="../data/user-store.txt"

# Function to initiate registration by admin
initiate_registration() {
    email=$1
    uuid=$(uuidgen)
    echo "$email:$uuid:Patient" >> $USER_STORE
    echo "Registration initiated. UUID: $uuid"
}

# Function to complete registration by patient
complete_registration() {
    uuid=$1
    echo "Enter First Name:"
    read first_name
    echo "Enter Last Name:"
    read last_name
    echo "Enter Date of Birth (YYYY-MM-DD):"
    read dob
    echo "Are you HIV positive? (yes/no):"
    read hiv_status
    diagnosis_date=""
    on_art=""
    art_start_date=""
    if [ "$hiv_status" == "yes" ]; then
        echo "Enter diagnosis date (YYYY-MM-DD):"
        read diagnosis_date
        echo "Are you on ART? (yes/no):"
        read on_art
        if [ "$on_art" == "yes" ]; then
            echo "Enter ART start date (YYYY-MM-DD):"
            read art_start_date
        fi
    fi
    echo "Enter Country ISO Code:"
    read country_code
    echo "Enter Password:"
    read -s password
    hashed_password=$(echo -n $password | openssl dgst -sha256 | awk '{print $2}')
    echo "$uuid:$first_name:$last_name:$dob:$hiv_status:$diagnosis_date:$on_art:$art_start_date:$country_code:$hashed_password" >> $USER_STORE
}

# Function to log in user
login_user() {
    email=$1
    password=$2
    hashed_password=$(echo -n $password | openssl dgst -sha256 | awk '{print $2}')
    while IFS=: read -r stored_email stored_uuid stored_role stored_first_name stored_last_name stored_dob stored_hiv_status stored_diagnosis_date stored_on_art stored_art_start_date stored_country_code stored_hashed_password
    do
        if [ "$email" == "$stored_email" ] && [ "$hashed_password" == "$stored_hashed_password" ]; then
            echo "Login successful"
            return 0
        fi
    done < $USER_STORE
    echo "Invalid email or password"
    return 1
}

# Function to export user data
export_user_data() {
    cp $USER_STORE ../data/exported_user_data.csv
    echo "User data exported successfully."
}

# Main script logic
case "$1" in
    "initiate_registration") initiate_registration $2 ;;
    "complete_registration") complete_registration $2 ;;
    "login_user") login_user $2 $3 ;;
    "export_user_data") export_user_data ;;
    *) echo "Invalid option" ;;
esac
